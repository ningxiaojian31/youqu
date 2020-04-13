package cn.zdxh.invitation.mapper;

import cn.zdxh.commons.dto.TCommentBackDTO;
import cn.zdxh.commons.entity.TComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TCommentMapper extends BaseMapper<TComment> {
    List<TCommentBackDTO> findAllByCommentDTO(Page page, @Param("tComment") TCommentBackDTO tComment);
}
