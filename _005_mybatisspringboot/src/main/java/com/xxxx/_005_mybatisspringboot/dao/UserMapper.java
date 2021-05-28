package com.xxxx._005_mybatisspringboot.dao;

import com.xxxx._005_mybatisspringboot.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HMF on 2021/05/27 18:09
 */
//@Mapper   // 如果在入口类没有写 @MapperScan 注解配置，在这里就要写 @Mapper 注解，这个注解表示了这是一个 mybatis 的 mapper 类：Dao
//@Repository  // 在 service 注入时使用 @Autowire 有红色波浪线 在这里添加一个 @Repository 注解就行了

public interface UserMapper { // 接口
    /**
     * 根据用户名查询用户记录
     * @param userName
     * @return
     */
    public User queryUserByUserName(String userName);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryUserList();

    /**
     * 添加用户，返回的是受影响行数
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户，根据 id 删除，返回的是受影响行数
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     * 更改用户
     * @param user
     * @return
     */
    int updateUser(User user);
}




