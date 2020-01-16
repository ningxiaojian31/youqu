package cn.zdxh.user.client;

import cn.zdxh.commons.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用redis服务
 */
@FeignClient("youqu-service-other")
public interface RedisClient {
    //获取key-value值
    @GetMapping(value = "/other/cache/redis/{key}")
    Result get(String key);
}
