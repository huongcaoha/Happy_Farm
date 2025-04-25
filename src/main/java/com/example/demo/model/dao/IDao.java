package com.example.demo.model.dao;

import java.util.List;

public interface IDao<T> {
    public List<T> findAll();
    public T findById(int id);
    public int insert(T t);
    public int update(T t);
    public int delete(int id);
}
