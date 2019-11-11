package cn.zdxh.user.service.impl;

import cn.zdxh.commons.entity.TUser;
import cn.zdxh.user.service.IMessageProvider;
import cn.zdxh.user.stream.MqMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class MessageProviderImpl implements IMessageProvider {
    @Autowired
    public Source source;

    @Override
    public void send(TUser tUser) {
        source.output().send(MessageBuilder.withPayload(tUser).build());
    }
}
