package cn.zdxh.redis.service.impl;

import cn.zdxh.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void put(String key, Object val) {
        redisTemplate.opsForValue().set(key, val);
    }

    @Override
    public void put(String key, Object val, int minute) {
        redisTemplate.opsForValue().set(key, val, TimeUnit.MINUTES.toMillis(minute));
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
