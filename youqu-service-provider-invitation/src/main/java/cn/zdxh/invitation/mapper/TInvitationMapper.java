package cn.zdxh.invitation.mapper;

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
    List<TInvitation> findAllByInvitation(Page page,@Param("tInvitation") TInvitation tInvitation);

}
