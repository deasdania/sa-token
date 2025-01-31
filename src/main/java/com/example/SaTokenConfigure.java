package com.example;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.dao.SaTokenDaoRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class SaTokenConfigure {

    @Bean
    public SaTokenConfig saTokenConfig(RedisConnectionFactory redisConnectionFactory) {
        SaTokenConfig config = new SaTokenConfig();

        // Create the SaTokenDaoRedis instance (Session DAO using Redis)
        SaTokenDaoRedis redisDao = new SaTokenDaoRedis(redisConnectionFactory);

        // Set the DAO for storing sessions in Redis
        config.setTokenSessionStore(redisDao);

        return config;
    }
}
