package cn.zdxh.user.feign;

import cn.zdxh.commons.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用redis服务
 */
@FeignClient("youqu-service-redis")
public interface RedisClient {
    //获取key-value值
    @GetMapping(value = "redis/{key}")
    public Result get(@PathVariable String key);
}
