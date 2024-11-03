package com.example.Thymeleaf.Project.service;

import com.example.Thymeleaf.Project.entity.User;

import java.util.List;

public interface UserService {

    void create(User user);
    List<User> getAllUser();
    User getById(Long id);
    void deleteById(Long id);
}
