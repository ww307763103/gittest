package com.example.security.controller;

import com.example.security.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL
 * @since 1.0.0
 */
@RestController
public class TestRestController {

    /**
     * request对象
     */
    @Autowired
    private HttpServletRequest request;

    /*@Autowired
    private RedisConfig redisConfig;*/
    @Value("${spring.redis.port: #{6666}}")
    private Integer port;

    /**
     * 测试
     * @return 返回
     */
    @RequestMapping("/hello")
    public Integer helloWorld() {
        System.out.println("测试冲突44");
        return port;
    }

}
