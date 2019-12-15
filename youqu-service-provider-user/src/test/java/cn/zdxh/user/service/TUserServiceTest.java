package cn.zdxh.user.service;

import cn.zdxh.commons.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TUserServiceTest {

    @Autowired
    public TUserService tUserService;

    @Test
    void contextLoads() {
        TUser tUser = tUserService.getById(1);
        System.out.println(tUser);
    }

    @Test
    void testLogin() {
//        TUser tUser = new TUser();
//        tUser.setUsername("11111111");
//        tUser.setPassword("22222222");
//        Boolean login = tUserService.login(tUser);
//        System.out.println(login);
    }





}
