package com.example.demo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private final StringRedisTemplate redisTemplate;

    private String secretKeyBase64;
    private Key SECRET_KEY;

    @Autowired
    public JwtUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Setter for secret key, to be injected from application.yml
    @Value("${jwt.secret-key}")
    public void setSecretKey(String secretKeyBase64) {
        this.secretKeyBase64 = secretKeyBase64;

        if (secretKeyBase64 == null || secretKeyBase64.isEmpty()) {
            throw new IllegalArgumentException("JWT secret key must be provided.");
        }

        byte[] decodedKey = Base64.getDecoder().decode(secretKeyBase64);
        this.SECRET_KEY = Keys.hmacShaKeyFor(decodedKey);
    }

    // Generate and store JWT token in Redis
    public String createToken(long loginId) {
        // Create JWT token
        String token = Jwts.builder()
                .setSubject(String.valueOf(loginId))
                .signWith(SECRET_KEY)
                .compact();

        // Store token in Redis with an expiration time (e.g., 1 hour)
        redisTemplate.opsForValue().set("token:" + loginId, token, 1, TimeUnit.HOURS);
        return token;
    }

    // Parse and validate the token
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validate token by checking Redis for its existence
    public boolean validateToken(String token) {
        // Retrieve loginId from token to check against Redis
        Claims claims = parseToken(token);
        long loginId = Long.parseLong(claims.getSubject());

        // Retrieve token from Redis using the loginId key
        String storedToken = redisTemplate.opsForValue().get("token:" + loginId);
        
        // Check if the token exists in Redis and matches the provided token
        return storedToken != null && storedToken.equals(token);
    }

    // Retrieve login ID from token (if valid)
    public long getLoginIdFromToken(String token) {
        Claims claims = parseToken(token);
        return Long.parseLong(claims.getSubject());
    }
}
