package cn.zdxh.invitation.service;

import cn.zdxh.commons.dto.TInvitationDTO;
import cn.zdxh.commons.dto.TInvitationDetailDTO;
import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.commons.form.CollectForm;
import cn.zdxh.commons.form.LaudForm;
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

    TInvitationDetailDTO findByIdOnFront(Integer id);

    Page findAllByInvitation(Page page , TInvitationDTO tInvitationDTO);

    Page findAllByInvitationOnFront(Page page);

    LaudForm addLaud(LaudForm laudForm);

    Integer countLaud(String poId);

    CollectForm moveCollect(CollectForm collectForm);

    Boolean orCollect(CollectForm collectForm);

    CollectForm addCollect(CollectForm collectForm);

    Page findCollectAllByUserId(Page page, Integer userId);
}
