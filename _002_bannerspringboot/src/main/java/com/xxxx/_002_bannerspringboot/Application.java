package com.xxxx._002_bannerspringboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        // 设置 banner 图标的关闭
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
