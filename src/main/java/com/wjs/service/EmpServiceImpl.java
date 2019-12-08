package com.wjs.service;

import com.wjs.dao.EmpDao;
import com.wjs.entity.Emp;
import com.wjs.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageBean<Emp> findByPage(Integer currentPage, Integer rows, Integer deptId) {
        try {
            //1调用dao层查询商品总记录数
            System.out.println("部门号:" + deptId);
            Integer totalCount = empDao.countByDeptId(deptId);
            if (totalCount == 0) {
                return null;
            }
            System.out.println("该部门员工总数:" + totalCount);
            //2计算总页码
            System.out.println(currentPage + "  " + rows);
            Integer totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
            if (currentPage > totalPage) currentPage = totalPage;
            //3调用dao层 查询指定范围的员工List集合
            //计算当前页首条记录索引
            Integer start = (currentPage - 1) * rows;
            //Integer end=start+rows-1;
            List<Emp> list = empDao.queryByPage(start, rows, deptId);
            for (Emp p : list) {
                System.out.println(p);
            }
            PageBean<Emp> pageBean = new PageBean<>(totalCount, totalPage, list, currentPage, rows);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("分页查询员工失败");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp findEmpById(Integer id) {
        try {
            return empDao.queryById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 查询指定员工 失败");
        }
    }

    @Override
    public void addEmp(Emp emp) {
        try {
            empDao.insert(emp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加员工 失败");
        }
    }

    @Override
    public void updateEmp(Emp emp) {
        try {
            empDao.update(emp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(" 更新员工失败");
        }
    }

    @Override
    public void removeEmp(Integer id) {
        try {
            empDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除指定员工 失败");
        }
    }

    public void removeByDeptId(Integer deptId) {
        try {
            empDao.deleteByDeptId(deptId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除部门下员工 失败");
        }
    }
}
