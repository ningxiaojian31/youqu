package cn.zdxh.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //开启Feign远程调用
public class YouquServiceMsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceMsgApplication.class, args);
    }

}
