package cn.zdxh.other.redis.service.impl;

import cn.zdxh.other.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void put(String key, String val) {
        redisTemplate.opsForValue().set(key, val);
    }

    @Override
    public void put(String key, String val, int minute) {
        redisTemplate.opsForValue().set(key, val, minute, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }
}
