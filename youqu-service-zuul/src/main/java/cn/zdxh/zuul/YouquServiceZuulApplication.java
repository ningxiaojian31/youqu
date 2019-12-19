package cn.zdxh.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(scanBasePackages = {"cn.zdxh.zuul","cn.zdxh.commons"})
@EnableEurekaClient
@EnableZuulProxy //开启zuul代理
public class YouquServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceZuulApplication.class, args);
    }

}
