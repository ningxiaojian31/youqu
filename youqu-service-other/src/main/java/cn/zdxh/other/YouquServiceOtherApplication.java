package cn.zdxh.other;

import cn.zdxh.other.utils.MqStream;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(scanBasePackages = {"cn.zdxh.other","cn.zdxh.commons"})
@EnableEurekaClient
@EnableBinding(MqStream.class)
@MapperScan("cn.zdxh.other.log.mapper")
public class YouquServiceOtherApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceOtherApplication.class, args);
    }

}
