package com.example.demo.model.dao;

import com.example.demo.model.entity.User;

public interface IAuth {
    public User login(String username, String password);
}
