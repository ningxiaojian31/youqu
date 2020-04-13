package cn.zdxh.user.controller;


import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.form.TUserForm;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.user.service.IMessageProvider;
import cn.zdxh.user.service.TUserService;
import cn.zdxh.commons.utils.SystemLog;
import cn.zdxh.commons.utils.SystemLogEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    @SystemLog(type = SystemLogEnum.REGISTER_LOG)
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody @Validated TUserForm tUserForm,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultHelper.createSuccess(tUserService.register(tUserForm));
    }

    @SystemLog(type = SystemLogEnum.LOGIN_LOG)
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Validated TUserDTO tUserDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new WebRuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        TUserDTO userResult = tUserService.login(tUserDTO);
        return ResultHelper.createSuccess(userResult);
    }

    @ApiOperation("获取所有用户")
    @GetMapping("/gets")
    public Result findAll(){
        return ResultHelper.createSuccess(tUserService.findAll());
    }

    @ApiOperation("查询所有用户")
    @PostMapping("/list")
    public Result list(@RequestBody TUser tUser,
                       @RequestParam(value = "currentPage",required = false) Integer currentPage,
                       @RequestParam(value = "pageSize",required = false) Integer pageSize){
        Page page = new Page();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(tUserService.findAllByUser(page,tUser));
    }

    @SystemLog(type = SystemLogEnum.DELETE_LOG)
    @ApiOperation("删除用户")
    @DeleteMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean res = tUserService.removeById(id);
        if (res){
            return ResultHelper.createSuccess("删除用户成功");
        }
        return ResultHelper.createError("删除用户失败");
    }

    @ApiOperation("管理员登录")
    @PostMapping("/admin/login")
    public Result adminLogin(@RequestBody TUserDTO tUserDTO){
        return ResultHelper.createSuccess(tUserService.adminLogin(tUserDTO));
    }

    @ApiOperation("查询用户详情/前台")
    @GetMapping("/front/get/{userId}")
    public Result frontGet(@PathVariable Integer userId){
        return ResultHelper.createSuccess(tUserService.findByIdOnFront(userId));
    }


    @ApiOperation("查询用户个人信息/前台")
    @GetMapping("/front/info/get/{userId}")
    public Result findInfoByIdFront(@PathVariable Integer userId){
        return ResultHelper.createSuccess(tUserService.getById(userId));
    }

    @ApiOperation("我的页面/前台")
    @GetMapping("/front/personal/get/{userId}")
    public Result findPersonByIdFront(@PathVariable Integer userId){
        return ResultHelper.createSuccess(tUserService.getPersonById(userId));
    }

    @SystemLog(type = SystemLogEnum.SAVE_LOG)
    @ApiOperation("修改用户个人信息/前台")
    @PostMapping("/front/info")
    public Result updateUserInfoFront(@RequestBody TUser tUser){
        tUser.setModifyTime(new Date());
        boolean result = tUserService.updateById(tUser);
        if (result){
            return ResultHelper.createSuccess(tUser);
        }else {
            return ResultHelper.createError("保存失败");
        }
    }


}

