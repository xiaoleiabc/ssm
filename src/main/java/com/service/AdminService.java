package com.service;


import com.pojo.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdmin();
    void addAdmin(Admin admin);
}
