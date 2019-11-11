package cn.zdxh.msg.config;

import cn.jsms.api.common.SMSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
public class JiguangMsgConfig {

    @Value("${sms.appkey}")
    private String appkey;
    @Value("${sms.secret}")
    private String masterSecret;

    @Bean
    public SMSClient smsClient(){
        SMSClient client = new SMSClient(masterSecret, appkey);
        return client;
    }
}
