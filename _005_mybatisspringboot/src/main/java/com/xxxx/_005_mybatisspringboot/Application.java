package com.xxxx._005_mybatisspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @MapperScan 注解对应 dao 接口所在的包，没有该注解，程序启动不起来
// 为了方便，在应用程序运行的时候，给这些接口创建代理，配置 dao 所在的包名
@MapperScan("com.xxxx._005_mybatisspringboot.dao")  // 这里没有写 @MapperScan 注解，就要在 dao 层的 接口里加 @Mapper 注解
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
