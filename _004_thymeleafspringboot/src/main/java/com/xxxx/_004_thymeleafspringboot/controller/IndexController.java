package com.xxxx._004_thymeleafspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by HMF on 2021/05/27 10:15
 */

/**
 * 注意这里的注解是 @Controller ***************************
 */
@Controller
public class IndexController {
    /**
     * 这个方法和下面的方法效果都是一样的，只是不同的实现方法 转发视图
     * @return
     */
    @RequestMapping("test")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("test_msg", "Hello my test thymeleaf!!! hhahahahha");
        mv.setViewName("test");
        return mv;
    }

    /**
     * 提供转发视图的方法
     * @param model
     * @return
     */
    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("index_msg", "Hello index thymeleaf!!!");
        model.addAttribute("userName","hmf");
        model.addAttribute("sex", "男");
        return "index";
    }
}
