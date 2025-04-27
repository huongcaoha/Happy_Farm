package com.example.demo.model.dao;

import com.example.demo.model.entity.User;

public interface IAuth {
    public User login(String username, String password);
    public boolean checkUsernameExisted(String username);
    public boolean checkEmailExisted(String email);
}
