package cn.zdxh.invitation.client;

import cn.zdxh.commons.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 远程调用redis服务
 */
@FeignClient(name = "youqu-service-other",path = "/cache")
public interface RedisClient {
    //点赞-收藏
    @PostMapping("redis/set/put/{key}/{val}")
    Result putSet(@PathVariable String key, @PathVariable Object val);

    //获取点赞总数
    @GetMapping(value = "/redis/set/count/{key}")
    Result putSetCount(@PathVariable String key);

    //是否收藏
    @PostMapping("redis/set/or/{key}/{val}")
    Result putSetOr(@PathVariable String key, @PathVariable Object val);

    //取消收藏
    @PostMapping("redis/set/move/{key}/{val}")
    Result moveSet(@PathVariable String key, @PathVariable Object val);

    //根据收藏人查询收藏的帖子
    @GetMapping(value = "redis/set/{key}")
    Result getSet(@PathVariable String key);

}
