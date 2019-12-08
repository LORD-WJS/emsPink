package com.wjs.dao;

import com.wjs.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao extends BaseDao<Emp> {
    public Integer countByDeptId(Integer deptId);

    public List<Emp> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows,
                                 @Param("deptId") Integer deptId);

    public void deleteByDeptId(Integer deptId);
}
