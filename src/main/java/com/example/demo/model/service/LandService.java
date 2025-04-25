package com.example.demo.model.service;

import com.example.demo.model.dao.LandDao;
import com.example.demo.model.entity.Land;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LandService implements IService<Land>{
    @Autowired
    private LandDao landDao;

    @Override
    public List<Land> findAll() {
        return landDao.findAll();
    }

    @Override
    public Land findById(int id) {
        return landDao.findById(id);
    }

    @Override
    public int insert(Land land) {
        return landDao.insert(land);
    }

    @Override
    public int update(Land land) {
        return landDao.update(land);
    }

    @Override
    public int delete(int id) {
        return landDao.delete(id);
    }
}
