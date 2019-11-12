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



}
