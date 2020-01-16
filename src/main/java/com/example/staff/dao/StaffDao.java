package com.example.staff.dao;
/**
 * staff接口层
 */

import com.example.staff.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffDao {

    //添加
    int insert(Staff staff);

    //删除
    int deleteById(Integer id);

    //修改
    int updateById(Staff staff);

    //查询列表
    List<Staff> getAll();

    //根据id查询
    Staff getById(Integer id);
}
