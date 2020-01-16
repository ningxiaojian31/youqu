package cn.zdxh.oss;

import cn.zdxh.other.qiniu.service.QiniuFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YouquServiceOtherApplicationTests {

    @Autowired
    QiniuFileService service;
    @Test
    void contextLoads() {
//        service.upload();
    }


}
