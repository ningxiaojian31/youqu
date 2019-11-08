package cn.zdxh.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YouquServiceMsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceMsgApplication.class, args);
    }

}
