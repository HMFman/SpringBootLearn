package com.xxxx._006_swaggerspringboot.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by HMF on 2021/05/30 20:45
 */
@Data
//@Api(value = "这里写注释，一般写在模块上")   // 这个注解我测试的时候没有显示其内容
@ApiModel(value = "User用户实体类")
public class User {
    @ApiModelProperty(value = "id")
    public int id;

    @ApiModelProperty(value = "用户名")
    public String userName;

    @ApiModelProperty(value = "密码")
    public String userPwd;
}
