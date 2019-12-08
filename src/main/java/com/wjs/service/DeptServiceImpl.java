package com.wjs.service;

import com.wjs.dao.DeptDao;
import com.wjs.dao.EmpDao;
import com.wjs.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmpDao empDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Dept> findAll() {
        try {
            List<Dept> depts = deptDao.queryAll();
            return depts;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 查询所有部门失败");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Dept findById(Integer id) {
        try {
            Dept dept = deptDao.queryById(id);
            return dept;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 查询指定部门失败");
        }
    }

    @Override
    public void add(Dept dept) {
        try {
            deptDao.insert(dept);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 添加部门失败");
        }
    }

    @Override
    public void update(Dept dept) {
        try {
            deptDao.update(dept);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 更新部门失败");
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            deptDao.delete(id);
            empDao.deleteByDeptId(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除部门 失败");
        }
    }
}
