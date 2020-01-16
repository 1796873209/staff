package com.example.staff.service;

import com.example.staff.dao.StaffDao;
import com.example.staff.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffDao staffDao;

    //添加
    public int insert(Staff staff){
        return staffDao.insert(staff);
    }

    //删除
    public int delete(Integer id){
        return staffDao.deleteById(id);
    }

    //修改
    public int update(Staff staff){
        return staffDao.updateById(staff);
    }

    //查询列表
    public List<Staff> getAll(){
        return staffDao.getAll();
    }

    //根据id查询
    public Staff getById(Integer id){
        return staffDao.getById(id);
    }
}
