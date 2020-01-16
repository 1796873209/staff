package com.example.staff.web;
/**
 * 控制层
 */

import com.example.staff.entity.Admin;
import com.example.staff.entity.Staff;
import com.example.staff.service.AdminService;
import com.example.staff.service.StaffService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    StaffService staffService;

    //跳转到注册页面
    @RequestMapping("/doregister")
    public String doRegister(){
        return "register";
    }

    //注册
    @RequestMapping("/register")
    @ResponseBody
    public boolean  register(Admin admin){
        //姓名和密码不为空
        if (StringUtils.isNotEmpty(admin.getName()) && StringUtils.isNotEmpty(admin.getPassword())){
           int t=adminService.insertAdmin(admin);
           if (t==1){
               return true;
           }else {
               return false;
           }
        }else {
            return false;
        }
    }



    //跳转到登录页面
    @RequestMapping("/dologin")
    public String doLogin(){
        return "login";
    }

    //登录
    @RequestMapping("/login")
    public String login(Admin admin, Model model, HttpServletRequest request){
        //用户名和密码不为空
        if (StringUtils.isNotEmpty(admin.getName()) && StringUtils.isNotEmpty(admin.getPassword())){
            //获取要登陆的用户信息
            Admin admin1=adminService.login(admin);
            if (admin1==null){
                //要登陆的信息为空，返回错误
                return "fail";
            }
            //将登陆信息保存到session中
            HttpSession session=request.getSession();
            session.setAttribute("aname",admin.getName());
            session.setAttribute("apassword",admin.getPassword());

            //向前端传递数据
            List<Staff> staffList=staffService.getAll();
            model.addAttribute("admin",admin);
            model.addAttribute("staffList",staffList);
            return "index";
        }
        return "fail";
    }



    //跳转到添加页面
    @RequestMapping("/doadd")
    public String doAdd(){
        return "add";
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public boolean add(Staff staff){
        int t=staffService.insert(staff);
        if (t==1) {
            return true;
        }
        return false;
    }



    //跳转到修改页面
    @RequestMapping("/doupdate/{id}")
    public String doUpdate(@PathVariable Integer id,Model model){
        //根据id获取要修改的员工信息
        Staff staff=staffService.getById(id);

        //传递数据到前端
        model.addAttribute("staff",staff);

        return "update";
    }

    //修改员工信息
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Staff staff){
        int t=staffService.update(staff);
        if (t==1){
            return true;
        }
        return false;
    }



    //删除员工信息
    @RequestMapping("/dodelete/{id}")
    public String doDelete(@PathVariable Integer id){
        int t=staffService.delete(id);
        if (t==1){
            return "success";
        }
        return "fail";
    }



    //进行其他操作后返回主页并更新，重复登录
    @RequestMapping("/index")
    public String index(Admin admin,Model model,HttpServletRequest request){

        //获取保存在session中的信息
        HttpSession session=request.getSession();
        String name= (String) session.getAttribute("aname");
        String password= (String) session.getAttribute("apassword");
        admin.setName(name);
        admin.setPassword(password);

        //登录
        Admin admin1=adminService.login(admin);

        //传递数据到前端
        List<Staff> staffList=staffService.getAll();
        model.addAttribute("admin",admin1);
        model.addAttribute("staffList",staffList);

        return "index";

    }

}
