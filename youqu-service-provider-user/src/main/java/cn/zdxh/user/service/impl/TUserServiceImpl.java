package cn.zdxh.user.service.impl;

import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.dto.TUserDetailDTO;
import cn.zdxh.commons.dto.TUserPersonDTO;
import cn.zdxh.commons.entity.TFocusFans;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.form.TUserForm;
import cn.zdxh.commons.utils.JwtUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.user.enums.FansFocusEnum;
import cn.zdxh.user.client.RedisClient;
import cn.zdxh.user.mapper.TFocusFansMapper;
import cn.zdxh.user.mapper.TUserMapper;
import cn.zdxh.user.service.IMessageProvider;
import cn.zdxh.user.service.TUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.util.Date;
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

    @Autowired
    private TFocusFansMapper tFocusFansMapper;


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
        //远程调用Redis服务
        Result resultRedis = redisClient.get("reg_"+tUserForm.getUsername());
        //验证码通过
        if (resultRedis.getData() != null && tUserForm.getMsgCode().equals(resultRedis.getData())){
            TUser tUser = new TUser();
            BeanUtils.copyProperties(tUserForm,tUser);
            Date date = new Date();
            tUser.setCreateTime(date);
            tUser.setModifyTime(date);
            //密码加密
            String md5Password = DigestUtils.md5DigestAsHex(tUser.getPassword().getBytes());
            tUser.setPassword(md5Password);
            int register = tUserMapper.insert(tUser);
            if (register > 0){
                //生成token
                String token = JwtUtils.sign(tUser.getUsername(), tUser.getId());
                BeanUtils.copyProperties(tUser,tUserForm);
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
    public TUserDTO login(TUserDTO tUserDTO) {
        TUser userResult = loginCheck(tUserDTO);
        if (userResult != null){
            String token = "";
            if (userResult.getType() != null && userResult.getType() == 2){
                //用户，生成token
                BeanUtils.copyProperties(userResult,tUserDTO);
                token = JwtUtils.sign(tUserDTO.getUsername(), tUserDTO.getId());
                tUserDTO.setToken(token);
            }else {
                throw new WebRuntimeException("账号异常！");
            }
        }else {
            throw new WebRuntimeException("用户名或密码错误！");
        }
        return tUserDTO;
    }

    @Override
    public TUserDTO adminLogin(TUserDTO tUserDTO) {
        TUser userResult = loginCheck(tUserDTO);
        if (userResult != null){
            String token = "";
            if (userResult.getType() != null && userResult.getType() == 1){
                //管理员，生成token
                BeanUtils.copyProperties(userResult,tUserDTO);
                token = JwtUtils.sign(tUserDTO.getUsername(), tUserDTO.getId());
                tUserDTO.setToken(token);
            }else if (userResult.getType() != null && userResult.getType() == 2){
                throw new WebRuntimeException("不是管理员账号！");
            }else {
                throw new WebRuntimeException("账号异常！");
            }
        }else {
            throw new WebRuntimeException("用户名或密码错误！");
        }
        return tUserDTO;
    }

    @Override
    public List<TUser> findAll() {
        return tUserMapper.findAll();
    }

    @Override
    public TUserDetailDTO findByIdOnFront(Integer userId) {
        TUserDetailDTO detailDTO = new TUserDetailDTO();
        TUser tUser = tUserMapper.selectById(userId);
        if (tUser == null){
            throw new WebRuntimeException("没有该用户！");
        }
        BeanUtils.copyProperties(tUser,detailDTO);
        //查询粉丝和关注
        List<TFocusFans> focusFansList = tFocusFansMapper.findFocusAndFansByUserId(userId);
        if (!CollectionUtils.isEmpty(focusFansList)){
            Integer fans = 0;
            Integer focus = 0;
            for (TFocusFans focusFans : focusFansList){
                if (detailDTO.getId() == focusFans.getUserId()){
                    if (focusFans.getType() == FansFocusEnum.FANS_ENUM.getType()){
                        fans = fans + 1;
                    }else if (focusFans.getType() == FansFocusEnum.FOCUS_ENUM.getType()){
                        focus = focus + 1;
                    }
                }

            }
            detailDTO.setFans(fans);
            detailDTO.setFocus(focus);
        }
        return detailDTO;
    }

    @Override
    public TUserPersonDTO getPersonById(Integer userId) {
        //查询个人信息
        TUser tUser = tUserMapper.selectById(userId);
        if (tUser == null){
            throw new WebRuntimeException("查无此人");
        }
        TUserPersonDTO personDTO = new TUserPersonDTO();
        BeanUtils.copyProperties(tUser,personDTO);
        //查询关注数和粉丝数
        QueryWrapper<TFocusFans> wrapperFocus = new QueryWrapper();
        QueryWrapper<TFocusFans> wrapperFans = new QueryWrapper();
        wrapperFocus.eq("user_id",userId);
        wrapperFocus.eq("type",FansFocusEnum.FOCUS_ENUM.getType());
        wrapperFans.eq("user_id",userId);
        wrapperFans.eq("type",FansFocusEnum.FANS_ENUM.getType());
        //封装
        personDTO.setFocusCount(String.valueOf(tFocusFansMapper.selectCount(wrapperFocus)));
        personDTO.setFansCount(String.valueOf(tFocusFansMapper.selectCount(wrapperFans)));

        return personDTO;
    }

    @Override
    public Page findAllByUser(Page page, TUser tUser) {
        page.setRecords(tUserMapper.findAllByUser(page,tUser));
        return page;
    }

    public TUser loginCheck(TUserDTO tUserDTO){
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
}
