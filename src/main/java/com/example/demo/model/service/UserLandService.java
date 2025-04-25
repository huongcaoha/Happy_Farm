package com.example.demo.model.service;

import com.example.demo.model.dao.UserLandDao;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserLand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLandService implements IService<UserLand> {
    @Autowired
    private UserLandDao userLandDao;


    @Override
    public List<UserLand> findAll() {
        return userLandDao.findAll();
    }

    @Override
    public UserLand findById(int id) {
        return userLandDao.findById(id);
    }

    @Override
    public int insert(UserLand userLand) {
        return userLandDao.insert(userLand);
    }

    @Override
    public int update(UserLand userLand) {
        return userLandDao.update(userLand);
    }

    @Override
    public int delete(int id) {
        return userLandDao.delete(id);
    }
}
