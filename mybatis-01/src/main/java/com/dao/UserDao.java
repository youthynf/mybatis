package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    int addOne(User user);

    int deleteOne(int id);

    int update(User user);
}
