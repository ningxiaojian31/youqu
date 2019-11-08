package cn.zdxh.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YouquServiceConsumerFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceConsumerFrontApplication.class, args);
    }

}
