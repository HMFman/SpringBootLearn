package com.xxxx._001_hellospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HMF on 2021/05/26 21:53
 */

/**
 * 加了 spring-boot-starter-web 依赖坐标才有 @RestController 注解
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!!!";
    }
}