package cn.zdxh.invitation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YouquServiceProviderInvitationApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceProviderInvitationApplication.class, args);
    }

}
