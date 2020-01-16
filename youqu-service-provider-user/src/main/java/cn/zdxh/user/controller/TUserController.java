package cn.zdxh.user.controller;


import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.form.TUserForm;
import cn.zdxh.commons.utils.JwtUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.user.client.RedisClient;
import cn.zdxh.user.service.IMessageProvider;
import cn.zdxh.user.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@Api(tags = "用户/管理员控制器")
@RestController
@RequestMapping("/tUser")
public class TUserController {

    @Autowired
    private IMessageProvider provider;

    @Autowired
    private TUserService tUserService;


    /**
     * 发送验证码邮箱
     * @param tUserDTO
     * @return
     */
    @ApiOperation("用户-发送验证码")
    @PostMapping("/send")
    public Result sendMsg(@RequestBody @Validated TUserDTO tUserDTO,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //做邮箱验证
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        tUserService.sendMsg(tUserDTO);
        return ResultHelper.createSuccess("发送邮件成功！");
    }

    /**
     * 注册
     * @param tUserForm
     * @param bindingResult
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody @Validated TUserForm tUserForm,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultHelper.createSuccess(tUserService.register(tUserForm));
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Validated TUserDTO tUserDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        TUser userResult = tUserService.login(tUserDTO);
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
            return ResultHelper.createSuccess(tUserDTO);
        }
        return ResultHelper.createError("用户名或密码错误！");
    }

    @ApiOperation("获取所有用户")
    @GetMapping("/gets")
    public Result findAll(){
        return ResultHelper.createSuccess(tUserService.findAll());
    }

    @ApiOperation("管理员登录")
    @PostMapping("/admin/login")
    public Result adminLogin(@RequestBody TUserDTO tUserDTO){
        TUser userResult = tUserService.login(tUserDTO);
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
            return ResultHelper.createSuccess(tUserDTO);
        }
        return ResultHelper.createError("用户名或密码错误！");
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

