package com.example.staff.dao;
/**
 * admin接口层
 */

import com.example.staff.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminDao {

    //注册
    int insertAdmin(Admin admin);

    //登录
    Admin login(Admin admin);
}
