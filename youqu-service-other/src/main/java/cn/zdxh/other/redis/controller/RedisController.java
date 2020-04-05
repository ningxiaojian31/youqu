package cn.zdxh.other.redis.controller;

import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.other.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping(value = "redis/set/{key}")
    public Result getSet(@PathVariable String key) {
        return ResultHelper.createSuccess(redisService.getSet(key));
    }

    @PostMapping("redis/set/put/{key}/{val}")
    public Result putSet(@PathVariable String key, @PathVariable Object val) {
        redisService.putSet(key,val);
        return ResultHelper.createSuccess(null);
    }

    @GetMapping(value = "redis/set/count/{key}")
    public Result putSetCount(@PathVariable String key) {
        return ResultHelper.createSuccess(redisService.putSetCount(key));
    }

    @PostMapping("redis/set/or/{key}/{val}")
    public Result putSetOr(@PathVariable String key, @PathVariable Object val) {
        return ResultHelper.createSuccess(redisService.putSetOr(key,val));
    }

    @PostMapping("redis/set/move/{key}/{val}")
    public Result moveSet(@PathVariable String key, @PathVariable Object val) {
        redisService.moveSet(key,val);
        return ResultHelper.createSuccess(null);
    }

    @GetMapping(value = "redis/keys/{key}")
    public Result getKeys(@PathVariable String key) {
        return ResultHelper.createSuccess(redisService.getTypeKeys(key));
    }

    @GetMapping(value = "memory")
    public Result memory() {
        return ResultHelper.createSuccess(sun.misc.VM.maxDirectMemory()/(double)1024/1024+"MB");
    }
}