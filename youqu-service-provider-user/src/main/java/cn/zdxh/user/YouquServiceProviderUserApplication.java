package cn.zdxh.user;

import cn.zdxh.user.utils.MqStream;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"cn.zdxh.user","cn.zdxh.commons"})
@EnableEurekaClient
@MapperScan("cn.zdxh.user.mapper")
@EnableBinding(MqStream.class)
@EnableAsync //开启异步
@EnableFeignClients //开启Feign远程调用
public class YouquServiceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceProviderUserApplication.class, args);
    }

}
