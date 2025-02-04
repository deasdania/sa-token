package com.example.demo.config;

import com.example.demo.JwtUtil;
import com.example.demo.grpc.AuthServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    private final JwtUtil jwtUtil;

    public GrpcConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthServiceImpl authService() {
        return new AuthServiceImpl(jwtUtil);
    }
}
