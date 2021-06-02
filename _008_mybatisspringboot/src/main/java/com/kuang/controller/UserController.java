package com.kuang.controller;

import com.kuang.pojo.User;
import com.kuang.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by HMF on 2021/06/02 18:19
 */

@Controller
public class UserController {
    @Autowired
    UserServices userServices;  // 注入 services层 的 UserServices

    /**
     * 根据 id 查询用户
     * 访问方法：http://localhost:8080/user/1
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}")
    public ModelAndView queryUserById(@PathVariable int id) {
        User user = userServices.queryById(id);
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("user", user);
        return mv;
    }

    /**
     * 查询所有的用户
     * 访问方法：http://localhost:8080/user
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/user")
    public String queryAll(Model model) {
        List<User> users = userServices.queryAll();
        model.addAttribute("users", users);
        return "userList";
    }

    /**
     * 添加用户
     * 访问方法：http://localhost:8080/addUser?name=锋锋&age=5
     *
     * @param user
     * @return
     */
    @ResponseBody // 加了这注解就可以直接输出字符串，是在类上加了 @Controller 的基础上
    @RequestMapping(value = "/addUser")
    public String addUser(User user) {
//        User user = new User("测试人", 33);
        return userServices.addUser(user) >= 1 ? "添加用户成功！！！" : "添加用户失败！！！";
    }


    /**
     * 另一种添加用户的方法
     * 访问方法：http://localhost:8080/add
     *
     * @return
     */
    @ResponseBody // 加了这注解就可以直接输出字符串，是在类上加了 @Controller 的基础上
    @RequestMapping(value = "/add")
    public String add() {
        // 实体类 User 就加 lombok 的 @Data 注解就好了
        User user = new User();
        user.setName("哈哈");
        user.setAge(20);
        return userServices.addUser(user) >= 1 ? "添加用户成功！！！" : "添加用户失败！！！";
    }

    /**
     * 根据 id 删除用户
     * 访问方法：http://localhost:8080/delete/5
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") int id) {
        return userServices.deleteById(id) >= 1 ? "删除用户成功！！！" : "删除用户失败！！！";
    }


    /**
     * 根据 id 更新用户
     * 访问方法：http://localhost:8080/update/9
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update/{id}")
    public String updateById(@PathVariable(value = "id") int id) {
        User user = new User();
        user.setName("在一起");
        user.setAge(100);
        user.setId(id);
        return userServices.updateById(user) >= 1 ? "更新用户成功！！！" : "更新用户失败！！！";
    }


    /**
     * 另一种 根据 id 更新用户的方法
     * 访问方法：http://localhost:8080/update?name=zhonghua&age=15&id=9
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(User user) {
        return userServices.updateById(user) >= 1 ? "更新用户成功！！！" : "更新用户失败！！！";
    }
}
