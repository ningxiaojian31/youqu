package cn.zdxh.other.email.mq;


import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.other.email.service.IMailService;
import cn.zdxh.other.utils.MqStream;
import cn.zdxh.other.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 监听MQ短信
 */
@Service
@Slf4j
public class EmailMqListener {

    @Autowired
    IMailService iMailService;

    @Autowired
    RedisService redisService;

    //redis过期时间，这里是10分钟
    @Value("${time.minute}")
    Integer minute;

    @StreamListener(MqStream.EMAIL_INPUT)
    public void input(TUserDTO tUserDTO) throws IOException {
        log.info(tUserDTO.toString());
        String code = "";
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            code = String.valueOf((int)((Math.random()*9+1)*1000)); //随机生成4位数的验证码
            redisService.put("reg_"+tUserDTO.getUsername(),code,minute);  //将值暂存到redis
        }catch (Exception e){
            e.printStackTrace();
            log.error("生成验证码发生异常："+e.getMessage());
        }finally {
            lock.unlock();
        }

        //发送邮箱
        String content = "您的注册验证码："+code+"有效期10分钟，请勿泄露。如非本人操作，请忽略此邮箱。谢谢！";
        iMailService.sendSimpleMail(tUserDTO.getUsername(),"友趣社区",content);
    }


}
