package com.example.demo.model.service;

import com.example.demo.model.entity.User;

public interface AuthService {
    public User login(String username, String password);
}
