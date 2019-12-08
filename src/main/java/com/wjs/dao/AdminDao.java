package com.wjs.dao;

import com.wjs.entity.Admin;

public interface AdminDao extends BaseDao<Admin> {
    public Admin queryByUsername(String username);

}
