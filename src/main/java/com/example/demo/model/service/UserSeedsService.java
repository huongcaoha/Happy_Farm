package com.example.demo.model.service;

import com.example.demo.model.dao.UserSeedsDao;
import com.example.demo.model.entity.UserSeeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeedsService implements IService<UserSeeds> {
    @Autowired
    private UserSeedsDao userSeedsDao;

    @Override
    public List<UserSeeds> findAll() {
        return userSeedsDao.findAll();
    }

    @Override
    public UserSeeds findById(int id) {
        return userSeedsDao.findById(id);
    }

    @Override
    public int insert(UserSeeds userSeeds) {
        return userSeedsDao.insert(userSeeds);
    }

    @Override
    public int update(UserSeeds userSeeds) {
        return userSeedsDao.update(userSeeds);
    }

    @Override
    public int delete(int id) {
        return userSeedsDao.delete(id);
    }
}
