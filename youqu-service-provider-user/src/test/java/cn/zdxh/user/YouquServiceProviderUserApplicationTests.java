package cn.zdxh.user;

import cn.zdxh.commons.entity.TUser;
import cn.zdxh.user.mapper.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class YouquServiceProviderUserApplicationTests {

    @Autowired
    private TUserMapper tUserMapper;

    @Test
    void contextLoads() {
        List<TUser> all = tUserMapper.findAll();
        for (TUser tUser : all){
            System.out.println(tUser);
        }
    }

}
