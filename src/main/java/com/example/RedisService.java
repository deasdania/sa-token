package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    // Set a value in Redis
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Get a value from Redis
    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Increment a value
    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key, 1);
    }
}
