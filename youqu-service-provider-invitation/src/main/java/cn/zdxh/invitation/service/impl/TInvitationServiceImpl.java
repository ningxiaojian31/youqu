package cn.zdxh.invitation.service.impl;

import cn.zdxh.commons.dto.TCommentDTO;
import cn.zdxh.commons.dto.TInvitationDTO;
import cn.zdxh.commons.dto.TInvitationDetailDTO;
import cn.zdxh.commons.dto.TInvitationFrontDTO;
import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.commons.form.CollectForm;
import cn.zdxh.commons.form.LaudForm;
import cn.zdxh.commons.utils.JwtUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.invitation.client.RedisClient;
import cn.zdxh.invitation.enums.CollectAndLaudEnum;
import cn.zdxh.invitation.enums.InvCheckStatusEnum;
import cn.zdxh.invitation.mapper.TInvitationMapper;
import cn.zdxh.invitation.service.TInvitationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
@Slf4j
public class TInvitationServiceImpl extends ServiceImpl<TInvitationMapper, TInvitation> implements TInvitationService {

    @Autowired
    private TInvitationMapper tInvitationMapper;

    @Autowired
    private RedisClient redisClient;

    @Override
    public int saveEntity(TInvitation tInvitation) {
        int res = 0;
        if (tInvitation.getId() != null){
            res = tInvitationMapper.updateById(tInvitation);
        }else {
            tInvitation.setCreateTime(new Date());
            res = tInvitationMapper.insert(tInvitation);
        }
        return res;
    }

    @Override
    public TInvitationDetailDTO findByIdOnFront(Integer id) {
        TInvitationDetailDTO detailDTO = tInvitationMapper.findByIdOnFront(id);
        if (detailDTO != null){
            //获取帖子赞总数
            if (detailDTO.getId() != null){
                Integer laud = countLaud(CollectAndLaudEnum.LAUD_INV.getName() + detailDTO.getId());
                if (laud != null){
                    detailDTO.setInvLaud(String.valueOf(laud));
                }
            }

            //获取评论赞总数
            List<TCommentDTO> commentList = detailDTO.getCommentList();
            if (!CollectionUtils.isEmpty(commentList)){
                commentList.stream().forEach(comment -> {
                    if (comment != null && comment.getId() != null){
                        Integer laud = countLaud(CollectAndLaudEnum.LAUD_COM.getName() +detailDTO.getId()+"-"+ comment.getId());
                        if (laud != null){
                            comment.setComLaud(String.valueOf(laud));
                        }
                    }
                });
            }
        }
        return detailDTO;
    }

    @Override
    public Page findAllByInvitation(Page page, TInvitationDTO tInvitationDTO) {
        List<TInvitationDTO> invitations = tInvitationMapper.findAllByInvitation(page, tInvitationDTO);
        for (TInvitationDTO invitation : invitations) {
            //封装审核状态
            InvCheckStatusEnum statusEnum = InvCheckStatusEnum.getStatusName(invitation.getInvStatus());
            if (statusEnum != null){
                invitation.setInvStatusName(statusEnum.getName());
            }
            //获取帖子赞总数
            if (invitation.getId() != null){
                Integer laud = countLaud(CollectAndLaudEnum.LAUD_INV.getName() + invitation.getId());
                if (laud != null){
                    invitation.setInvLaud(String.valueOf(laud));
                }
            }
        }
        page.setRecords(invitations);
        return page;
    }

    @Override
    public Page findAllByInvitationOnFront(Page page) {
        page.setRecords(tInvitationMapper.findAllByInvitationOnFront(page));
        return page;
    }

    @Override
    public LaudForm addLaud(LaudForm laudForm) {
        redisClient.putSet(laudForm.getPoId(),laudForm.getUserId());
        return laudForm;
    }

    @Override
    public Integer countLaud(String poId) {
        Result result = redisClient.putSetCount(poId);
        return (Integer) result.getData();
    }

    @Override
    public CollectForm moveCollect(CollectForm collectForm) {
        redisClient.moveSet(collectForm.getUserId(), collectForm.getPoId());
        return collectForm;
    }

    @Override
    public Boolean orCollect(CollectForm collectForm) {
        Result result = redisClient.putSetOr(collectForm.getUserId(), collectForm.getPoId());
        return (Boolean) result.getData();
    }

    @Override
    public CollectForm addCollect(CollectForm collectForm) {
        redisClient.putSet(collectForm.getUserId(),collectForm.getPoId());
        return collectForm;
    }

    @Override
    public Page findCollectAllByUserId(Page page, Integer userId) {
        //收藏的key表达式
        String key = CollectAndLaudEnum.COLLEC_INV.getName()+userId;
        Result result = redisClient.getSet(key);
        if (result.getCode()!= null && result.getCode() == 1){
            List<String> ids = (List<String>)result.getData();
            //根据id集合查询所有帖子
            if (!CollectionUtils.isEmpty(ids)){
                page.setRecords(tInvitationMapper.selectBatchIds(ids));//这里实际上没做分页
            }
        }else {
            throw new WebRuntimeException("查询收藏失败");
        }
        return page;
    }

    /**
     * 定时任务-自动审核帖子
     * 每10分钟执行一次
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    public void checkInvitationByTimer(){
        //查询所有还没审核的帖子
        Map map = new HashMap();
        map.put("inv_status",InvCheckStatusEnum.NO_CHECK_INV.getCode());
        try {
            log.info("====================================");
            log.info("开始执行自动审核帖子定时任务...");
            List<TInvitation> invitations = tInvitationMapper.selectByMap(map);
            if (!CollectionUtils.isEmpty(invitations)){
                List<Integer> ids = invitations.stream().map(item ->  item.getId()).collect(Collectors.toList());
                //批量更新
                tInvitationMapper.updateBatchByIds(ids);
            }
        }catch (Exception e){
            log.error(e.getMessage());
            log.info("执行自动审核帖子定时任务出现异常!");
            log.info("====================================");
            return;
        }
        log.info("执行自动审核帖子定时任务成功！");
        log.info("====================================");

    }
}
