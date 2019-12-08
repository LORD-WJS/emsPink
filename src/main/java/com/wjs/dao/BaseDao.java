package com.wjs.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    public List<T> queryAll();

    public List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    public T queryById(Integer id);

    public void insert(T t);

    public void update(T t);

    public void delete(Integer id);

}
