package com.wjs.controller;

import com.wjs.entity.Emp;
import com.wjs.entity.PageBean;
import com.wjs.service.DeptService;
import com.wjs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    @RequestMapping("showEmpByDept")
    public String showEmpByDept(HttpServletRequest request, Integer currentPage, Integer rows, Integer deptId) {
        HttpSession session = request.getSession();
        session.setAttribute("currentDeptId", deptId);
        if (currentPage == null || currentPage == 0) currentPage = 1;
        if (rows == null) rows = 4;
        if (deptId == null) deptId = (Integer) session.getAttribute("currentDeptId");
        PageBean<Emp> pb = empService.findByPage(currentPage, rows, deptId);
        request.setAttribute("pb", pb);
        return "/emp/empList";
    }

    @RequestMapping("searchEmpById")
    public String searchEmpById(HttpServletRequest request, Integer id) {
        Emp emp = empService.findEmpById(id);
        request.setAttribute("emp", emp);
        return "/emp/updateEmp";
    }

    @RequestMapping("increaseEmp")
    public String increaseEmp(Emp emp) {
        empService.addEmp(emp);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("changeEmp")
    public String changeEmp(Emp emp) {
        System.out.println("更新员工的生日:" + emp.getBirthday());
        empService.updateEmp(emp);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("dropEmp")
    public String dropEmp(Integer id) {
        empService.removeEmp(id);
        return "redirect:/dept/showAll";
    }
}
