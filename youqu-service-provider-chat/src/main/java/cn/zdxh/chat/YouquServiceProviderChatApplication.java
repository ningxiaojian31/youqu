package cn.zdxh.chat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"cn.zdxh.chat","cn.zdxh.commons"})
@EnableEurekaClient
@MapperScan("cn.zdxh.chat.mapper")
public class YouquServiceProviderChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceProviderChatApplication.class, args);
    }

}
