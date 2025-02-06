package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.example.demo.satoken.SaTokenBeanInjection;
import com.example.demo.satoken.StpInterfaceImpl;

import cn.dev33.satoken.application.ApplicationInfo;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.dao.SaTokenDaoRedisJackson;
import cn.dev33.satoken.log.SaLog;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.log.SaLog;
import cn.dev33.satoken.log.SaLogForConsole;
import cn.dev33.satoken.spring.SaBeanInject;
import cn.dev33.satoken.spring.SaTokenContextForSpring;
import cn.dev33.satoken.spring.json.SaJsonTemplateForJackson;
import cn.dev33.satoken.stp.StpLogic;

// import org.redisson.api.RedissonClient;

/**
 * [Sa-Token 权限认证] 配置类 
 * @author click33
 *
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {


    @Value("${sa.route.prefix}")
    private String routePrefix;

	/**
	 * 注册 Sa-Token 拦截器打开注解鉴权功能  
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册 Sa-Token 拦截器打开注解鉴权功能 
		registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
	}

	@Bean
    public SaLog saLog() {
        return new SaLogForConsole(); // Ensure SaLog has a no-argument constructor
    }

    /**
     * Sa-Token 整合 jwt 
     */
	@Bean
    public StpLogic getStpLogicJwt() {
    	return new StpLogicJwtForSimple();
    }
    
    @Bean
    public SaTokenBeanInjection saTokenBeanInjection(
            SaLog log,
            SaTokenConfig config,
            RedisConnectionFactory connectionFactory
    ) {
        return new SaTokenBeanInjection(log, config, connectionFactory, routePrefix);
    }

    @Bean
    public SaBeanInject saBeanInject(
            SaLog log,
            SaTokenConfig config,
            RedisConnectionFactory connectionFactory
    ) {
        SaBeanInject inject = new SaBeanInject(log, config);

        // 基于 Spring 的上下文处理器
        inject.setSaTokenContext(new SaTokenContextForSpring());

        // 基于 Jackson 的 json解析器
        inject.setSaJsonTemplate(new SaJsonTemplateForJackson());

        // 基于 Jackson 序列化的 Redis 持久化组件
        SaTokenDaoRedisJackson saTokenDaoRedisJackson = new SaTokenDaoRedisJackson();
        saTokenDaoRedisJackson.init(connectionFactory);
        inject.setSaTokenDao(saTokenDaoRedisJackson);

        // 权限和角色数据
        inject.setStpInterface(new StpInterfaceImpl());

        // 项目路由前缀，方便路由拦截鉴权的
        ApplicationInfo.routePrefix = routePrefix;

        return inject;
    }
}