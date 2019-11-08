package cn.zdxh.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YouquServiceEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceEsApplication.class, args);
    }

}
