package cn.zdxh.msg.service;


import cn.zdxh.commons.entity.TUser;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * 监听MQ短信
 */
@Service
@EnableBinding(Sink.class)
public class MsgService {

    @StreamListener(Sink.INPUT)
    public void input(TUser tUser) throws IOException {
        System.out.println(tUser);
    }

}
