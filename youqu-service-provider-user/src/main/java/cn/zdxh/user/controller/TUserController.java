package cn.zdxh.user.controller;


import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.form.TUserForm;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.user.client.RedisClient;
import cn.zdxh.user.service.IMessageProvider;
import cn.zdxh.user.service.TUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@RestController
@RequestMapping("/tUser")
public class TUserController {

    @Autowired
    private IMessageProvider provider;

    @Autowired
    private TUserService tUserService;

    @Autowired
    private RedisClient redisClient;

    /**
     * 发送验证码短信
     * @param tUserDTO
     * @return
     */
    @PostMapping("/send")
    public Result sendMsg(@RequestBody TUserDTO tUserDTO,BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()){
            //做手机号验证
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        tUserService.sendMsg(tUserDTO);
        result.success("发送短信成功！");
        return result;
    }

    /**
     * 注册
     * @param tUserForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody TUserForm tUserForm,BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()){
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        Result resultRedis = redisClient.get(tUserForm.getUsername()+"_reg");
        //验证码通过
        if (resultRedis.getData() != null && tUserForm.getMsgCode().equals(resultRedis.getData())){
            TUser tUser = new TUser();
            BeanUtils.copyProperties(tUserForm,tUser);
            Boolean register = tUserService.register(tUser);
            if (register){
                result.success(tUser);
                return result;
            }
        }
        result.error("验证码错误或过期");
        return result;
    }

    @PostMapping("/login")
    public Result login(@RequestBody TUserDTO tUserDTO, BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()){
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        Boolean login = tUserService.login(tUserDTO);
        if (login){
            result.success(tUserDTO);
            return result;
        }
        return result;
    }

    @GetMapping("/gets")
    public Result findAll(){
        Result result = new Result();
        List<TUser> all = tUserService.findAll();
        result.success(all);
        return result;
    }

//    @GetMapping("/test")
//    public Result testStream(){
//        Result result = new Result();
//        try {
//            TUser user = new TUser();
//            user.setUsername("13189461916");
//            user.setPassword("123456");
//            user.setNickname("Justin");
//            provider.send(user);
//            result.success(true);
//        }catch (Exception e){
//            e.printStackTrace();
//            result.error(e.getMessage());
//        }
//        return result;
//    }


}

