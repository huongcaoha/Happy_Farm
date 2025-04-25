package com.example.demo.model.service;

import com.example.demo.model.dao.SeedsDao;
import com.example.demo.model.entity.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedsService implements IService<Seeds> {
    @Autowired
    private SeedsDao seedsDao;

    @Override
    public List<Seeds> findAll() {
        return seedsDao.findAll();
    }

    @Override
    public Seeds findById(int id) {
        return seedsDao.findById(id);
    }

    @Override
    public int insert(Seeds seeds) {
        return seedsDao.insert(seeds);
    }

    @Override
    public int update(Seeds seeds) {
        return seedsDao.update(seeds);
    }

    @Override
    public int delete(int id) {
        return seedsDao.delete(id);
    }
}
