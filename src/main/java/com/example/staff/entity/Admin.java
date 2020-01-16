package com.example.staff.entity;

/**
 * 管理员实体类
 */
public class Admin {
    private Integer id;    //编号
    private String name;   //姓名
    private String password;  //密码
    private String job;   //职位

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
