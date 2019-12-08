package com.wjs.service;


import com.wjs.entity.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();

    public Dept findById(Integer id);

    public void add(Dept dept);

    public void update(Dept dept);

    public void delete(Integer id);
}
