package cn.zdxh.user.service.impl;

import cn.zdxh.commons.entity.TFocusFans;
import cn.zdxh.user.enums.FansFocusEnum;
import cn.zdxh.user.mapper.TFocusFansMapper;
import cn.zdxh.user.service.TFocusFansService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 关注和粉丝表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
public class TFocusFansServiceImpl extends ServiceImpl<TFocusFansMapper, TFocusFans> implements TFocusFansService {

    @Autowired
    private TFocusFansMapper tFocusFansMapper;

    @Override
    public void addFocus(TFocusFans tFocusFans) {
        Date date = new Date();

        //关注
        Map mapFocus = new HashMap<>();
        mapFocus.put("user_id",tFocusFans.getUserId());
        mapFocus.put("friend_id",tFocusFans.getFriendId());
        mapFocus.put("type",FansFocusEnum.FOCUS_ENUM.getType());
        if (CollectionUtils.isEmpty(tFocusFansMapper.selectByMap(mapFocus))){
            tFocusFans.setType(FansFocusEnum.FOCUS_ENUM.getType());
            tFocusFans.setCreateTime(date);
            tFocusFansMapper.insert(tFocusFans);
        }

        //粉丝
        Map mapFans = new HashMap<>();
        mapFans.put("user_id",tFocusFans.getFriendId());
        mapFans.put("friend_id",tFocusFans.getUserId());
        mapFans.put("type",FansFocusEnum.FANS_ENUM.getType());
        if (CollectionUtils.isEmpty(tFocusFansMapper.selectByMap(mapFans))){
            TFocusFans tFans = new TFocusFans();
            tFans.setUserId(tFocusFans.getFriendId());
            tFans.setFriendId(tFocusFans.getUserId());
            tFans.setType(FansFocusEnum.FANS_ENUM.getType());
            tFans.setCreateTime(date);
            tFocusFansMapper.insert(tFans);
        }

    }

    @Override
    public void moveFocus(TFocusFans tFocusFans) {
        tFocusFansMapper.moveFocus(tFocusFans);
    }

    @Override
    public Boolean orFocus(TFocusFans tFocusFans) {
        List<TFocusFans> list = tFocusFansMapper.orFocus(tFocusFans);
        if (!CollectionUtils.isEmpty(list)){
            return true;
        }
        return false;
    }

    @Override
    public List<TFocusFans> findFocusAndFansByUserId(Integer userId) {
        return tFocusFansMapper.findFocusAndFansByUserId(userId);
    }
}
