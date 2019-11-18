package cn.zdxh.oss;

import cn.zdxh.oss.service.QiniuFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YouquServiceOssApplicationTests {

    @Autowired
    QiniuFileService service;
    @Test
    void contextLoads() {
//        service.upload();
    }


}
