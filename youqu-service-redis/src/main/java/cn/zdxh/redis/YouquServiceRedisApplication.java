package cn.zdxh.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YouquServiceRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceRedisApplication.class, args);
    }

}
