package cn.zdxh.user.service.impl;

import cn.zdxh.commons.entity.TFocusFans;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.user.enums.FansFocusEnum;
import cn.zdxh.user.mapper.TFocusFansMapper;
import cn.zdxh.user.mapper.TUserMapper;
import cn.zdxh.user.service.TFocusFansService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private TUserMapper tUserMapper;

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

    @Override
    public List<TUser> findAllFocusOrFansByUserId(Integer type,Integer userId) {
        List<TUser> tUsers = new ArrayList<>();
        Map map = new HashMap();
        if (type != null && type == FansFocusEnum.FOCUS_ENUM.getType()){
            //查询关注
            map.put("user_id",userId);
            map.put("type",FansFocusEnum.FOCUS_ENUM.getType());
            List<TFocusFans> list = tFocusFansMapper.selectByMap(map);
            //提炼出ids
            List<Integer> ids = list.stream().map(item -> item.getFriendId()).collect(Collectors.toList());
            //查询具体用户
            if (!CollectionUtils.isEmpty(ids)){
                tUsers = tUserMapper.selectBatchIds(ids);
            }
        }else if (type != null && type == FansFocusEnum.FANS_ENUM.getType()){
            //查询粉丝
            map.put("user_id",userId);
            map.put("type",FansFocusEnum.FANS_ENUM.getType());
            List<TFocusFans> list = tFocusFansMapper.selectByMap(map);
            //提炼出ids
            List<Integer> ids = list.stream().map(item -> item.getFriendId()).collect(Collectors.toList());
            //查询具体用户
            if (!CollectionUtils.isEmpty(ids)){
                tUsers = tUserMapper.selectBatchIds(ids);
            }
        }else {
            throw new WebRuntimeException("类型错误");
        }

        return tUsers;
    }

}
