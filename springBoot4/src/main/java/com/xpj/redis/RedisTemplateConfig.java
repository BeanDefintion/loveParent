package com.xpj.redis;

import com.xpj.user.domain.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplateConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        ValueOperations<String, String> ops = template.opsForValue();
        User user1 = new User();
        user1.setLabel("1111");
        String key1 = "xpj";
        for (int i = 0; i < 100; i++) {
            ops.set(key1, user1.getLabel());
            System.err.println(i);
        }

        return template;

    }

    public static void main(String[] args) {

    }
}
