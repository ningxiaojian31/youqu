package cn.zdxh.invitation.mapper;

import cn.zdxh.commons.entity.TComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    List<TComment> findAllByComment(@Param("map") Map<String,Object> map);
}
