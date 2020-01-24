package cn.zdxh.chat.config;

import cn.zdxh.chat.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ningxj
 * @date 2020-1-23 9:54
 */

@Component
public class IdConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(0, 0);
    }
}
