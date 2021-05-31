package com.xxxx._007_devtoolsspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HMF on 2021/05/31 11:20
 */

@RestController
public class DevToolsController {
    @RequestMapping(value = "/devtools")
    public String devtools() {
        return "热部署测试！！！！，again，again";
    }
}
