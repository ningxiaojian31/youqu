package cn.zdxh.other.redis.controller;

import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
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
        redisService.put(key, val);
        return ResultHelper.createSuccess(null);
    }

    @PostMapping("redis/{key}/{val}/{minute}")
    public Result put(@PathVariable String key, @PathVariable String val,@PathVariable Integer minute) {
        redisService.put(key, val,minute);
        return ResultHelper.createSuccess(null);
    }

    @GetMapping(value = "redis/{key}")
    public Result get(@PathVariable String key) {
        return ResultHelper.createSuccess(redisService.get(key));
    }
}