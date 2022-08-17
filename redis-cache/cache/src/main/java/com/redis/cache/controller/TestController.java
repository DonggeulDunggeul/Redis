package com.redis.cache.controller;

import com.redis.cache.service.TestService;
import com.redis.cache.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService svc;

    @Cacheable(value = "TestVo", key = "#id", cacheManager = "cacheManager", unless = "#id == ''",
        condition = "#id.length > 2")
    @GetMapping("/getTest")
    public TestVo getData(@RequestParam String id) {

        return svc.getTestSvc(id);
    }
}
