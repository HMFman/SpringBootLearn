package com.xxxx._002_bannerspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HMF on 2021/05/26 22:00
 */
@RestController
public class BannerController {
    @RequestMapping("banner")
    public String banner() {
        return "Banner 设置！！！";
    }
}
