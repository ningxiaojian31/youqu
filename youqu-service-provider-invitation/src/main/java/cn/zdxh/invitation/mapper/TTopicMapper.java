package cn.zdxh.invitation.mapper;

import cn.zdxh.commons.entity.TTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 话题表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TTopicMapper extends BaseMapper<TTopic> {
   List<TTopic> findAllByTopic(Page page, @Param("tTopic") TTopic tTopic);
}
