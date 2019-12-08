package com.wjs.service;


import com.wjs.entity.Emp;
import com.wjs.entity.PageBean;

public interface EmpService {
    public PageBean<Emp> findByPage(Integer currentPage, Integer rows, Integer deptId);

    public Emp findEmpById(Integer id);

    public void addEmp(Emp emp);

    public void updateEmp(Emp emp);

    public void removeEmp(Integer id);

    public void removeByDeptId(Integer deptId);

}
