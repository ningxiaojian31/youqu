package cn.zdxh.user.service;

import cn.zdxh.commons.entity.TFocusFans;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 关注和粉丝表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TFocusFansService extends IService<TFocusFans> {

    void addFocus(TFocusFans tFocusFans);

    void moveFocus(TFocusFans tFocusFans);

    Boolean orFocus(TFocusFans tFocusFans);

    List<TFocusFans> findFocusAndFansByUserId(Integer userId);
}
