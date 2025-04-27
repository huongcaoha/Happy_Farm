package com.example.demo.model.service;

import com.example.demo.model.entity.User;

public interface AuthService {
    public User login(String username, String password);
    public boolean checkUsernameExisted(String username);
    public boolean checkEmailExisted(String email);
}
