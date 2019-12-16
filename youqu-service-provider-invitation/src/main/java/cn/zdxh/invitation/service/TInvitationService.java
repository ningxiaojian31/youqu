package cn.zdxh.invitation.service;

import cn.zdxh.commons.entity.TInvitation;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TInvitationService extends IService<TInvitation> {

    int saveEntity(TInvitation tInvitation);

    Page findAllByInvitation(Page page ,TInvitation tInvitation);
}
