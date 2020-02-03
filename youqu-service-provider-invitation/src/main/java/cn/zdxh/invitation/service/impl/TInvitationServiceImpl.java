package cn.zdxh.invitation.service.impl;

import cn.zdxh.commons.dto.TCommentDTO;
import cn.zdxh.commons.dto.TInvitationDTO;
import cn.zdxh.commons.dto.TInvitationDetailDTO;
import cn.zdxh.commons.dto.TInvitationFrontDTO;
import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.commons.form.CollectForm;
import cn.zdxh.commons.form.LaudForm;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.invitation.client.RedisClient;
import cn.zdxh.invitation.mapper.TInvitationMapper;
import cn.zdxh.invitation.service.TInvitationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
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
                Integer laud = countLaud("laud-inv-" + detailDTO.getId());
                if (laud != null){
                    detailDTO.setInvLaud(String.valueOf(laud));
                }
            }

            //获取评论赞总数
            List<TCommentDTO> commentList = detailDTO.getCommentList();
            if (!CollectionUtils.isEmpty(commentList)){
                commentList.stream().forEach(comment -> {
                    if (comment != null && comment.getId() != null){
                        Integer laud = countLaud("laud-com-" +detailDTO.getId()+"-"+ comment.getId());
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
        page.setRecords(tInvitationMapper.findAllByInvitation(page,tInvitationDTO));
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
}
