package cn.zdxh.msg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置类
 */
@Component
public class JiguangMsgConfig {

    @Value("${sms.appkey}")
    private String appkey;

    @Value("${sms.secret}")
    private String masterSecret;


}
