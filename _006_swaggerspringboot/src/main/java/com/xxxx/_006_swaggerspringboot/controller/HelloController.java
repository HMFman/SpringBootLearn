package com.xxxx._006_swaggerspringboot.controller;

import com.xxxx._006_swaggerspringboot.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HMF on 2021/05/30 16:01
 */

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello! I'm testing swagger";
    }

    // 只要我们的接口中，返回值中存在实体类，他就会被扫描到 swagger 的 models 中
    @PostMapping(value = "/user")
    public User user() {
        return new User();
    }

    @ApiOperation(value = "hi方法")
    @GetMapping(value = "/hi")
    public String hi(@ApiParam(value = "用户名") String username) {
        return "hi,hi..." + username;
    }
}
