package cn.zdxh.invitation.mapper;

import cn.zdxh.commons.dto.TInvitationDTO;
import cn.zdxh.commons.dto.TInvitationDetailDTO;
import cn.zdxh.commons.dto.TInvitationFrontDTO;
import cn.zdxh.commons.entity.TInvitation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 帖子表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TInvitationMapper extends BaseMapper<TInvitation> {

    TInvitationDetailDTO findByIdOnFront(Integer id);

    List<TInvitationDTO> findAllByInvitation(Page page, @Param("tInvitation") TInvitationDTO tInvitationDTO);

    List<TInvitationFrontDTO> findAllByInvitationOnFront(Page page);

    void updateBatchByIds(@Param("ids") List<Integer> ids);
}
