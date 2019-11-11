package cn.zdxh.user.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface  MqMessageSource {
    String MY_OUT_PUT = "myOutPut";
    @Output(MY_OUT_PUT)
    MessageChannel testOutPut();
}
