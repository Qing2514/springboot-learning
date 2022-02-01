package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * RedisTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest
public class RedisTest {

    // 不与客户端Redis数据同步，以Object类型操作
    @Autowired
    private RedisTemplate redisTemplate;

    // 与客户端Redis数据同步，以String类型操作
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void set() {
        ValueOperations ops = redisTemplate.opsForValue();
        ValueOperations<String, String> sops = stringRedisTemplate.opsForValue();
        ops.set("age", 19);
        sops.set("age", "20");
        System.out.println("success set");
    }

    @Test
    void get() {
        ValueOperations ops = redisTemplate.opsForValue();
        ValueOperations<String, String> sops = stringRedisTemplate.opsForValue();
        Object age = ops.get("age");
        Object sage = sops.get("age");
        System.out.println(age);
        System.out.println(sage);
    }

    @Test
    void hset() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("info", "name", "abc");
        ops.put("info", "age", 18);
        System.out.println("success hset");
    }

    @Test
    void hget() {
        HashOperations ops = redisTemplate.opsForHash();
        Object name = ops.get("info", "name");
        System.out.println(name);
    }
}
