package cn.zdxh.other.qiniu.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Qiniu {

    @Value("${qiniu.access}")
    private String access;

    @Value("${qiniu.secret}")
    private String secret;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.url}")
    private String url;
}
