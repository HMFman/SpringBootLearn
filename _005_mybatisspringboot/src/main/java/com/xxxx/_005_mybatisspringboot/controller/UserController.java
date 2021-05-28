package com.xxxx._005_mybatisspringboot.controller;

import com.xxxx._005_mybatisspringboot.service.UserService;
import com.xxxx._005_mybatisspringboot.vo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HMF on 2021/05/27 18:36
 */

/**
 * 当前 控制器 下的返回值 全部都是 json
 *
 * @RestController 注解 返回的就是一个 json
 */

@RestController
public class UserController {
    @Resource
    private UserService userService; // 把 service 注入过来

    // 提供一个查询方法
    // @GetMapping 注解表示 get 查询
    // userName 是路径参数，所以要加 @PathVariable
    @GetMapping("/user/{userName}")
    public User queryUserByName(@PathVariable String userName) {
        return userService.queryUserByUserName(userName);
    }

    @GetMapping("/user")
    public List<User> queryUserList() {
        return userService.queryUserList();
    }

    // 添加一个用户
    @GetMapping("/addUser")
    public String addUser() {
        userService.addUser(new User(10, "lezijie", "666"));
        return "添加用户成功！！！";
    }

    // 删除一个用户
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userService.deleteUser(10);
        return "删除id=10的用户成功！！！";
    }

    // 修改一个用户
    @GetMapping("/updateUser")
    public String updateUser(){
        // 在实际项目中，这里还需要做一些判断
        userService.updateUser(new User(10, "update", "888"));
        return "修改id=10的用户成功！！！";
    }
}
