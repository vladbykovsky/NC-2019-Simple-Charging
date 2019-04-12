package com.example.backend.service;

import com.example.backend.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();
    User findByLogin(String login);
    User saveUser(User user);
    void deleteUser(int id);

}
