package com.diyo.uij.dao;

import com.diyo.uij.model.User;

import java.util.List;

public interface UserDao {

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User findUserById(int id);

    List<User> findAllUsers();
}
