package com.wjs.service;

import com.wjs.dao.AdminDao;
import com.wjs.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;


    @Override
    public Admin findByUsername(String username) {
        try {
            Admin admin = adminDao.queryByUsername(username);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 用户登录失败");
        }
    }

    @Override
    public void addAdmin(Admin admin) {
        try {
            adminDao.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 用户注册失败");
        }
    }
}
