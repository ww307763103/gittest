package com.example.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL
 * @since 1.0.0
 */
@RestController
public class TestRestController {
    @RequestMapping("/hello")
    public String helloWorld() {
        return "spring security hello world";
    }

}
