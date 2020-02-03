package cn.zdxh.user.mapper;

import cn.zdxh.commons.entity.TFocusFans;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 关注和粉丝表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TFocusFansMapper extends BaseMapper<TFocusFans> {

    void moveFocus(TFocusFans tFocusFans);

    List<TFocusFans> orFocus(TFocusFans tFocusFans);

    List<TFocusFans> findFocusAndFansByUserId(Integer userId);
}
