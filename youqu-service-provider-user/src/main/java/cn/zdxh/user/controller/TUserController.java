package cn.zdxh.user.controller;


import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.user.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public Result testStream(){
        Result result = new Result();
        try {
            TUser user = new TUser();
            user.setUsername("13189461916");
            user.setPassword("123456");
            user.setNickname("Justin");
            provider.send(user);
            result.success(true);
        }catch (Exception e){
            e.printStackTrace();
            result.error(e.getMessage());
        }
        return result;
    }

}

