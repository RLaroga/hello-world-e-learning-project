package com.helloWorld.helloWorld.service;

import com.helloWorld.helloWorld.common.utils.redis.RedisUtils;
import com.helloWorld.helloWorld.entity.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
public class SessionService {

    @Resource
    private RedisUtils redisUtils;

    @Value("${token.expireTime:30}")
    private int expireTime;

    public String createSession(User user) {
        String token = UUID.randomUUID().toString();
        redisUtils.strSet(token, user.getUsername(), Duration.ofDays(expireTime));
        return token;
    }

    public String getUsernameFromSession(String token) {
        return redisUtils.strGet(token);
    }

    public boolean isTokenValid(String token) {
        return redisUtils.hasKey(token);
    }

    public void deleteSession(String token) {
        redisUtils.delete(token);
    }
}
