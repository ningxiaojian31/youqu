package cn.zdxh.user.service.impl;

import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.form.TUserForm;
import cn.zdxh.commons.utils.JwtUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.commons.utils.WebRuntimeException;
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
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private RedisClient redisClient;


    @Override
    @Async //异步方法
    public void sendMsg(TUserDTO tUserDTO) {
        //通过mq异步发消息
        provider.send(tUserDTO);
    }

    @Override
    public TUserForm register(TUserForm tUserForm) {
        //查询该用户
        Map map = new HashMap<String,Object>();
        map.put("username",tUserForm.getUsername());
        List list = tUserMapper.selectByMap(map);
        if (!CollectionUtils.isEmpty(list)){
            throw new WebRuntimeException("该邮箱已注册！请登录");
        }
        Result resultRedis = redisClient.get("reg_"+tUserForm.getUsername());
        //验证码通过
        if (resultRedis.getData() != null && tUserForm.getMsgCode().equals(resultRedis.getData())){
            TUser tUser = new TUser();
            BeanUtils.copyProperties(tUserForm,tUser);
            int register = tUserMapper.insert(tUser);
            if (register > 0){
                //生成token
                String token = JwtUtils.sign(tUserForm.getUsername(), tUserForm.getId());
                tUserForm.setToken(token);
            }else {
                throw new WebRuntimeException("注册失败！请重试");
            }
        }else {
            throw new WebRuntimeException("验证码错误或过期");
        }
        return tUserForm;
    }

    @Override
    public TUser login(TUserDTO tUserDTO) {
        TUser tUser = new TUser();
        BeanUtils.copyProperties(tUserDTO,tUser);
        QueryWrapper<TUser> wrapper = new QueryWrapper<TUser>();
        //MD5加密
        String md5Password = DigestUtils.md5DigestAsHex(tUser.getPassword().getBytes());
        wrapper.eq("username",tUser.getUsername())
                .eq("password",md5Password);
        TUser userResult = tUserMapper.selectOne(wrapper);
        return userResult;
    }

    @Override
    public List<TUser> findAll() {
        return tUserMapper.findAll();
    }
}
