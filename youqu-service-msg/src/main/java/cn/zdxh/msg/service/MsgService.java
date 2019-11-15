package cn.zdxh.msg.service;


import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.msg.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * 监听MQ短信
 */
@Service
@EnableBinding(Sink.class)
public class MsgService {

    @Autowired
    IMailService iMailService;

    @Autowired
    RedisClient redisClient;

    //redis过期时间，这里是5分钟
    @Value("${time.minute}")
    Integer minute;

    @StreamListener(Sink.INPUT)
    public void input(TUserDTO tUserDTO) throws IOException {
        System.out.println(tUserDTO);
        String code;
        synchronized (this){
            code = String.valueOf((Math.random()*9+1)*10000); //随机生成5位数的验证码
            redisClient.put(tUserDTO.getUsername()+"_reg",code,minute);  //将值暂存到redis
        }

        //发送邮箱
        String content = "您的注册验证码："+code+"有效期5分钟，请勿泄露。如非本人操作，请忽略此邮箱。谢谢！";
        iMailService.sendSimpleMail(tUserDTO.getUsername(),"友趣社区",content);
    }

}
