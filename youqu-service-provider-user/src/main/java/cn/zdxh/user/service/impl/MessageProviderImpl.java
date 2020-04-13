package cn.zdxh.user.service.impl;

import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.user.service.IMessageProvider;
import cn.zdxh.user.utils.MqStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageProviderImpl implements IMessageProvider {
    @Autowired
    public MqStream stream;

    @Override
    public void send(TUserDTO tUser) {
        stream.emailOutput().send(MessageBuilder.withPayload(tUser).build());
    }
}
