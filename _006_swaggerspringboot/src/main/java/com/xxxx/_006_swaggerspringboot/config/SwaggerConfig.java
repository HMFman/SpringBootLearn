package com.xxxx._006_swaggerspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by HMF on 2021/05/30 16:20
 */

@Configuration   // 配置到 Spring Boot 中
@EnableSwagger2  // 开启 Swagger2
public class SwaggerConfig {
    /**
     * （1）第一种方法：来自字幕大神
     * 使用 @Value 注解，直接把从 application.yml 配置文件中获取的值，给到 active 属性
     * 然后在下面 判断 转化为 boolean 类型
     */
//    @Value(value = "${spring.profiles.active}")
//    private String active;

    /**
     * 另外一种方法：需要在 application.yml 中 配置 swagger.enable=true 或者 false，字段是自定义的
     * 应该是在各自的 application.yml 中配置，如 application-dev.yml 配置 true，application-prod.yml 配置 false
     */
//    @Value(value = "${swagger.enable}")
//    private boolean flag22;

//    @Bean
//    public Docket docket1() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("AA");
//    }
//
//    @Bean
//    public Docket docket2() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("BB");
//    }
//
//    @Bean
//    public Docket docket3() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("CC");
//    }

    @Bean
    public Docket docket(Environment environment) {
        /**
         * （2）第一种方法：来自字幕大神
         */
//        boolean flag = active.equals("dev");

        /**
         * 第二种方法：来自 狂神
         * 也可以直接 @Profile
         */
        // 设置要显示的 swagger 环境
        Profiles profiles = Profiles.of("dev", "test");
        // 通过 environment.acceptsProfiles 判断是否处在自己设定的环境当中，如上面定义的 dev，test
        boolean flag = environment.acceptsProfiles(profiles);


        // 配置了swagger 的 Docket 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("锋哥")
                // 是否开启 swagger，如果为 false，则 swagger 不能再浏览器中访问
                .enable(flag)
                // -------------------------------------------------------
                .select()
                // RequestHandlerSelectors：配置要扫描接口的方式
                // basePackage()：指定要扫描的包
                // any()：扫描全部
                // none()：不扫描
                // withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                // withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.xxxx._006_swaggerspringboot.controller"))
                // paths()：过滤什么路径
//                .paths(PathSelectors.ant("/com/**")) // 扫描指定路径下的
                .build(); // 类似建造者模式的 build
    }

    // 配置 swagger 信息 --> ApiInfo
    private ApiInfo apiInfo() {
        // 配置到下面的 ApiInfo 中的 作者信息
        Contact contact = new Contact(
                "锋哥",
                "https://blog.csdn.net/IT_Boy_",
                "123456@qq.com"
        );

        return new ApiInfo(
                "HMF的第一个API文档",
                "不念过去，不畏将来，只争朝夕。",
                "v1.0v",
                "https://blog.csdn.net/IT_Boy_",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
