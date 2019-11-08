package cn.zdxh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YouquServiceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceEurekaApplication.class, args);
    }

}
