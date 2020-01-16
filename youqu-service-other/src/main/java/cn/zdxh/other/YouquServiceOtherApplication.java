package cn.zdxh.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"cn.zdxh.other","cn.zdxh.commons"})
@EnableEurekaClient
public class YouquServiceOtherApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceOtherApplication.class, args);
    }

}
