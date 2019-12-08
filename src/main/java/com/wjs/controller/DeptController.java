package com.wjs.controller;

import com.wjs.entity.Dept;
import com.wjs.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;


    @ResponseBody
    @RequestMapping("searchAllDept")
    public List<Dept> searchAllDept() {
        List<Dept> deptList = deptService.findAll();
        return deptList;
    }

    @RequestMapping("showAll")
    public String showAll(Model model) {
        List<Dept> deptList = deptService.findAll();
        System.out.println(deptList.size());
        model.addAttribute("deptList", deptList);
        return "/dept/deptList";
    }

    @RequestMapping("beforeChange")
    public String beforeChange(Integer id, Model model) {
        Dept dept = deptService.findById(id);
        model.addAttribute("dept", dept);
        return "/dept/updateDept";
    }

    @RequestMapping("increaseDept")
    public String increaseDept(Dept dept) {
        deptService.add(dept);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("updateDept")
    public String updateDept(Dept dept) {
        deptService.update(dept);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("dropDept")
    public String dropDept(Integer id) {
        deptService.delete(id);
        return "redirect:/dept/showAll";
    }


}
