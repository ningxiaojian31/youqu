package cn.zdxh.other.redis.service.impl;

import cn.zdxh.other.redis.service.RedisService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void put(String key, String val) {
        stringRedisTemplate.opsForValue().set(key, val);
    }

    @Override
    public void put(String key, String val, int minute) {
        stringRedisTemplate.opsForValue().set(key, val, minute, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public void putSet(String key, Object val) {
        SetOperations ops = redisTemplate.opsForSet();
        if (!ops.isMember(key,val)){
            //不存在即添加
            ops.add(key,val);
        }
    }

    @Override
    public Long putSetCount(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    @Override
    public Boolean putSetOr(String key, Object val) {
        return redisTemplate.opsForSet().isMember(key,val);
    }

    @Override
    public void moveSet(String key, Object val) {
        redisTemplate.opsForSet().remove(key,val);
    }

    @Override
    public Set<String> getTypeKeys(String key) {
        return redisTemplate.keys(key);
    }

    @Override
    public Set<Object> getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }
}
