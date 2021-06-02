package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by HMF on 2021/06/02 18:14
 */

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User queryById(@Param(value = "id") int id);

    @Select("select * from user limit 10")
    List<User> queryAll();

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int addUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(int id);

    @Update("update user set name = #{name}, age = #{age} where id = #{id}")
    int updateById(User user);
}
