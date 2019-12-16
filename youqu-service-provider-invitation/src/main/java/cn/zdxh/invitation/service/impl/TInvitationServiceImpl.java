package cn.zdxh.invitation.service.impl;

import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.invitation.mapper.TInvitationMapper;
import cn.zdxh.invitation.service.TInvitationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Page findAllByInvitation(Page page, TInvitation tInvitation) {
        page.setRecords(tInvitationMapper.findAllByInvitation(page,tInvitation));
        return page;
    }
}
