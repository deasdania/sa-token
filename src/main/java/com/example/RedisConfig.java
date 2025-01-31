package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);  // Ensure Redis is running on port 6380
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Product> redisTemplate() {
        RedisTemplate<String, Product> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        
        // Set up serializers
        template.setKeySerializer(new StringRedisSerializer());  // For keys (String)
        template.setHashKeySerializer(new StringRedisSerializer());  // For hash keys (String)
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());  // For hash keys (String)
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());  // For hash values (Serialized Object)
        template.setValueSerializer(new JdkSerializationRedisSerializer());  // For values (Serialized Object)
        
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }
}
