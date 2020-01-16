package com.example.staff.service;

import com.example.staff.dao.AdminDao;
import com.example.staff.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    public int insertAdmin(Admin admin){
        return adminDao.insertAdmin(admin);
    }

    public Admin login(Admin admin){
        return adminDao.login(admin);
    }
}
