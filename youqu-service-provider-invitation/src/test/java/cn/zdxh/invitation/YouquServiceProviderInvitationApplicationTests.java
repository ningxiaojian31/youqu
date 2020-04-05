package cn.zdxh.invitation;

import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.invitation.mapper.TInvitationMapper;
import com.mysql.cj.result.IntegerValueFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class YouquServiceProviderInvitationApplicationTests {

    @Autowired
    private TInvitationMapper mapper;
    @Test
    void contextLoads() {
        String str = "abcccd";
        //真正的值
        String res = String.valueOf(str.charAt(0));
        for (int i=1;i < str.length();i++){

            if (!res.contains(String.valueOf(str.charAt(i)))){
                res = res + str.charAt(i);
            }

        }
        System.out.println(res);
    }

}
