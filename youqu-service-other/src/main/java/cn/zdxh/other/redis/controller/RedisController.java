package cn.zdxh.other.redis.controller;

import cn.zdxh.commons.utils.Result;
import cn.zdxh.other.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cache")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("redis/{key}/{val}")
    public Result put(@PathVariable String key, @PathVariable String val) {
        Result result = new Result();
        result.success(null);
        redisService.put(key, val);
        return result;
    }

    @PostMapping("redis/{key}/{val}/{minute}")
    public Result put(@PathVariable String key, @PathVariable String val,@PathVariable Integer minute) {
        Result result = new Result();
        result.success(null);
        redisService.put(key, val,minute);
        return result;
    }

    @GetMapping(value = "redis/{key}")
    public Result get(@PathVariable String key) {
        Result result = new Result();
        result.success((String) redisService.get(key));
        return result;
    }
}