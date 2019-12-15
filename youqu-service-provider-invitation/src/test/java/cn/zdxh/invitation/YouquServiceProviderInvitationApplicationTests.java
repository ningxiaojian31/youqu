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
        List<TInvitation> invitationList = mapper.findAllByInvitation2();
        invitationList.stream().forEach(System.out::println);
    }

}
