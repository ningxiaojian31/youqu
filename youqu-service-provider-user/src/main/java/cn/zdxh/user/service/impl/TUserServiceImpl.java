package cn.zdxh.user.service.impl;

import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.user.client.RedisClient;
import cn.zdxh.user.mapper.TUserMapper;
import cn.zdxh.user.service.IMessageProvider;
import cn.zdxh.user.service.TUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    public TUserMapper tUserMapper;

    @Autowired
    private IMessageProvider provider;


    @Override
    @Async //异步方法
    public void sendMsg(TUserDTO tUserDTO) {
        //通过mq异步发消息
        provider.send(tUserDTO);
    }

    @Override
    public Boolean register(TUser tUser) {
        int count = tUserMapper.insert(tUser);
        if (count > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean login(TUserDTO tUserDTO) {
        TUser tUser = new TUser();
        BeanUtils.copyProperties(tUserDTO,tUser);
        QueryWrapper<TUser> wrapper = new QueryWrapper<TUser>();
        //MD5加密
        String md5Password = DigestUtils.md5DigestAsHex(tUser.getPassword().getBytes());
        wrapper.eq("username",tUser.getUsername())
                .eq("password",md5Password);
        TUser userResult = tUserMapper.selectOne(wrapper);
        if (userResult != null){
            return true;
        }
        return false;
    }
}
