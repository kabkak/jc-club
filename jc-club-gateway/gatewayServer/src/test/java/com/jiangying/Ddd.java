package com.jiangying;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class Ddd {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {

        redisTemplate.opsForList().leftPush("user:permission:10001", "user:add");
        redisTemplate.opsForList().leftPush("user:role:10001", "admin");
    }

}
