package cn.zdxh.other.qiniu.config;

import cn.zdxh.other.qiniu.entity.Qiniu;
import com.qiniu.common.Zone;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QiniuConfig {

    @Autowired
    private Qiniu qiniu;

    @Bean
    public Auth auth(){
        Auth auth = Auth.create(qiniu.getAccess(), qiniu.getSecret());
        return auth;
    }

    @Bean
    public com.qiniu.storage.Configuration configuration(){
        Zone zone = Zone.autoZone();
        com.qiniu.storage.Configuration c = new com.qiniu.storage.Configuration(zone);
        return c;
    }
}
