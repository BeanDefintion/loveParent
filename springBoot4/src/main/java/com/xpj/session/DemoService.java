package com.xpj.session;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Cacheable(value = "keycache")
    public String testCache(String key) {
        System.out.println("testCache:" + key);
        return key;
    }
}
