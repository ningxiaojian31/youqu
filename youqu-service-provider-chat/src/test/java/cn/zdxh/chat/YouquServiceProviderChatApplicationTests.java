package cn.zdxh.chat;

import cn.zdxh.chat.mapper.TChatRecordMapper;
import cn.zdxh.commons.entity.TChatRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static sun.misc.Version.println;

@SpringBootTest
class YouquServiceProviderChatApplicationTests {

    @Autowired
    private TChatRecordMapper mapper;

    @Test
    void contextLoads() {
        List<TChatRecord> all = mapper.findAll();
        all.stream().forEach(System.out::println);

    }

}
