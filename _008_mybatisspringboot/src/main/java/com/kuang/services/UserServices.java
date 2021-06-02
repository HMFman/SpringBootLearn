package com.kuang.services;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HMF on 2021/06/02 18:16
 */
@Service
public class UserServices {
    @Resource
    UserMapper userMapper;  // 注入dao层的 UserMapper

    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    public int updateById(User user) {
        return userMapper.updateById(user);
    }
}
