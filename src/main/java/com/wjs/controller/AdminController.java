package com.wjs.controller;

import com.wjs.entity.Admin;
import com.wjs.service.AdminService;
import com.wjs.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(HttpServletRequest request, String username, String password) {
        HttpSession session = request.getSession();
        Admin admin = adminService.findByUsername(username);
        if (admin != null) {
            String salt = admin.getSalt();
            String pass = MD5Utils.getPassword(password + salt);
            if (pass.equals(admin.getPassword())) {
                session.setAttribute("admin", admin);
                System.out.println(admin.getRealname() + "登陆了");
                return "redirect:/dept/showAll";
            } else {
                return "user/login";
            }

        } else {
            return "login";
        }

    }

    @RequestMapping("regist")
    public String regist(HttpServletRequest request, Admin admin, String captchaCode) {
        HttpSession session = request.getSession();
        String securityCode = (String) session.getAttribute("securityCode");
        if (securityCode.equals(captchaCode)) {//验证码正确
            System.out.println(securityCode);
            System.out.println(captchaCode);
            //MD5加密
            String salt = MD5Utils.getSalt();
            String password = MD5Utils.getPassword(admin.getPassword() + salt);
            admin.setPassword(password);
            admin.setSalt(salt);
            adminService.addAdmin(admin);
            return "redirect:/user/login.jsp";
        } else {
            return "user/login";
        }


    }


}
