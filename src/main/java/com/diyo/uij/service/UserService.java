package com.diyo.uij.service;

import com.diyo.uij.model.User;

import java.util.List;

public interface UserService {

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User findUserById(int id);

    List<User> findAllUsers();
}
