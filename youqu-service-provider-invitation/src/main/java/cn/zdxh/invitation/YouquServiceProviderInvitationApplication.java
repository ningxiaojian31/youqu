package cn.zdxh.invitation;

import cn.zdxh.invitation.utils.MqStream;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * spring cloud项目，注意范围的使用，尤其是扫描范围
 */
@SpringBootApplication(scanBasePackages = {"cn.zdxh.invitation","cn.zdxh.commons"})
@EnableEurekaClient
@MapperScan("cn.zdxh.invitation.mapper")
@EnableSwagger2
@EnableBinding(MqStream.class)
@EnableFeignClients //开启Feign远程调用
@EnableScheduling //开启定时任务
public class YouquServiceProviderInvitationApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouquServiceProviderInvitationApplication.class, args);
    }

}
