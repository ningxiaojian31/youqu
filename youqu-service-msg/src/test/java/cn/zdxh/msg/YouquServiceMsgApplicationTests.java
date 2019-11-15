package cn.zdxh.msg;

import cn.jsms.api.SendSMSResult;
import cn.jsms.api.common.model.SMSPayload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YouquServiceMsgApplicationTests {


    @Autowired
    JSMSClient client;

    @Test
    void contextLoads() throws Exception {
        SMSPayload payload = SMSPayload.newBuilder()
                .setMobileNumber("13189461916")
                .setTempId(1)
                // .setSignId(1380)
                .build();
        SendSMSResult sendSMSResult = client.sendTemplateSMS(payload);
    }

}
