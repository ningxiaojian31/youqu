package cn.zdxh.invitation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.zdxh.invitation.mapper")
public class YouquServiceProviderInvitationApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceProviderInvitationApplication.class, args);
    }

}
