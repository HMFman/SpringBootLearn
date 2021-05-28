package com.xxxx._005_mybatisspringboot.service;

import com.xxxx._005_mybatisspringboot.dao.UserMapper;
import com.xxxx._005_mybatisspringboot.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by HMF on 2021/05/27 18:29
 */

/**
 * 使用 Service 去访问 Dao
 * <p>
 * 加 @Service 注解，交给 Ioc 进行实例化
 */
@Service
public class UserService {
    //    @Autowired  // 使用 该注解 有红色波浪线出现时，需要 dao 层相应的接口中 添加 @Repository 注解
    @Resource
    private UserMapper userMapper;  // 把 Dao 注入过来

    /**
     * 提供一个返回用户记录的方法
     * <p>
     * Service 方法定义好，在 Controller 中进行调用
     *
     * @param userName
     * @return
     */
    public User queryUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    // 添加一个用户
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    // 删除一个用户
    public int deleteUser(int id){
        return userMapper.deleteUser(id);
    }

    // 修改一个用户
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
}
