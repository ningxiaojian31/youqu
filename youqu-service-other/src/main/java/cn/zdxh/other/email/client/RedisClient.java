package cn.zdxh.other.email.client;

import cn.zdxh.commons.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("youqu-service-other")
public interface RedisClient {

    @PostMapping("redis/{key}/{val}/{minute}")
    Result put(@PathVariable String key, @PathVariable String val, @PathVariable Integer minute);
}
