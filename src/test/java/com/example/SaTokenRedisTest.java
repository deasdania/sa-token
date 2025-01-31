package com.example;

import cn.dev33.satoken.stp.StpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaTokenRedisTest {

    @Test
    public void testTokenGeneration() {
        // Create a login session for a user
        StpUtil.createLoginSession(12345L);

        // Generate token for the login session
        String token = StpUtil.getTokenValueByLoginId(12345L);

        // Assert token is not null or empty
        assert token != null && !token.isEmpty();

        System.out.println("Generated Token: " + token);
    }
}
