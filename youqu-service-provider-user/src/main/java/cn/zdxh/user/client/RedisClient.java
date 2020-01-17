package cn.zdxh.user.client;

import cn.zdxh.commons.utils.Result;
import cn.zdxh.user.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用redis服务
 */
@FeignClient(name = "youqu-service-other",path = "/cache",configuration = FeignConfiguration.class)
public interface RedisClient {
    //获取key-value值
    @GetMapping(value = "/redis/{key}")
    Result get(@PathVariable String key);
}
