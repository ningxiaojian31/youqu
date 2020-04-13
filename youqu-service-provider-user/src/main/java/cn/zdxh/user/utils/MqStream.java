package cn.zdxh.user.utils;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MqStream {

    String LOG_INPUT = "log_input";

    String LOG_OUTPUT = "log_output";

    String EMAIL_INPUT = "email_input";

    String EMAIL_OUTPUT = "email_output";

    @Input(LOG_INPUT)
    SubscribableChannel logInput();

    @Output(LOG_OUTPUT)
    MessageChannel logOutput();

    @Input(EMAIL_INPUT)
    SubscribableChannel emailInput();

    @Output(EMAIL_OUTPUT)
    MessageChannel emailOutput();
}
