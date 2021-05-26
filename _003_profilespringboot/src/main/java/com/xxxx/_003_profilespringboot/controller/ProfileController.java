package com.xxxx._003_profilespringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HMF on 2021/05/26 23:06
 */

@RestController
public class ProfileController {
    @RequestMapping("profile")
    public String profile(){
        return "profile全局配置文件设置不同的开发环境配置!!!";
    }
}
