package com.controller;

import com.pojo.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String adminName, String adminPassword, Model model){
        List<Admin> list=adminService.getAdmin();
        for (Admin admin:list){
            if (admin.getAdminName().equals(adminName)&&admin.getAdminPassword().equals(adminPassword)){
                return "redirect:/employee/page/1";
            }else {
                String message="name or password have error";
                model.addAttribute("message",message);
            }
        }
        return "";
    }

    @RequestMapping("/regist")
    public String regist(String adminName,String adminPassword){
        Admin admin=new Admin(adminName,adminPassword);
        adminService.addAdmin(admin);
        return "redirect:/";
    }

}
