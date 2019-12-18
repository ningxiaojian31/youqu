package cn.zdxh.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"cn.zdxh.oss","cn.zdxh.commons"})
@EnableEurekaClient
public class YouquServiceOssApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceOssApplication.class, args);
    }

}
