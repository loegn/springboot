package com.test.springboot.controller;

import com.test.springboot.dao.PermissionMapper;
import com.test.springboot.dao.RoleMapper;
import com.test.springboot.dao.UserMapper;
import com.test.springboot.pojo.Permission;
import com.test.springboot.pojo.Role;
import com.test.springboot.pojo.User;
import com.test.springboot.service.UserService;
import com.test.springboot.utils.PropUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@Controller
@RestController
public class MyController {
//    public static final Logger log = LoggerFactory.getLogger(IndexController.class);
//    @RequestMapping("/index")
//    public Object index(HttpServletRequest request, HttpServletResponse response){
//        request.getParameter("");
//        PropUtils.get("logging.level.root");
//        PropUtils.get("test.array[0].host");
//        PropUtils.get("test.c.a");
//        User user = userMapper.selectByPrimaryKey(1);
//        List<Role> roleList = roleMapper.selectByUserId(user.getId());
//        List<Permission> permissionsList = permissionMapper.selectByRoleId(roleList.get(0).getId());
//        return permissionsList;
//    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

/*    //错误页面展示
    @RequestMapping("/error")
    public String error(){
        return "error ok!";
    }*/


    @RequestMapping("/login")
    public Object login(String username,String password){
        if (username == null || password == null)
            return "用户名和密码不能为空";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            subject.login(usernamePasswordToken);
        }catch (Exception e){
            return e.getMessage();
        }
        return "login";
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }
}
