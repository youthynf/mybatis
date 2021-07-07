package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    // 03-new-2: 方法存在多个参数，所有的参数前面必须加上@Param注解
    //基本类型的参数或者string类型，需要加上
    //引用类型不需要加
    //如果只有一个基本类型的话，可以忽略，但是建议加上！
    //在sql中引用的就是这里的@param() 中的属性名！
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values(#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
