package com.example;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.dao.SaTokenDaoRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class SaTokenConfigure {

    // Configure Sa-Token with Redis for session management
    @Bean
    public SaTokenConfig saTokenConfig(RedisTemplate<String, Object> redisTemplate) {
        SaTokenConfig config = new SaTokenConfig();
        
        // Create the SaTokenDaoRedis instance (using RedisTemplate)
        SaTokenDaoRedis redisDao = new SaTokenDaoRedis();
        redisDao.init(redisTemplate.getConnectionFactory());  
        
        // Set the custom SaTokenDao for token storage
        // config.setTokenDao(redisDao);
        return config;
    }
}
