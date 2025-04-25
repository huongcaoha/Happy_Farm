package com.example.demo.model.service;

import java.util.List;

public interface IService<T> {
    public List<T> findAll();
    public T findById(int id);
    public int insert(T t);
    public int update(T t);
    public int delete(int id);
}
