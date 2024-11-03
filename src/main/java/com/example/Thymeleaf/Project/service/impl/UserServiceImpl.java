package com.example.Thymeleaf.Project.service.impl;

import com.example.Thymeleaf.Project.entity.User;
import com.example.Thymeleaf.Project.repository.UserRepo;
import com.example.Thymeleaf.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void create(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> userOptional =userRepo.findById(id);
        User user = null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else
            throw new RuntimeException("not found " + id);

        return user;
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

}
