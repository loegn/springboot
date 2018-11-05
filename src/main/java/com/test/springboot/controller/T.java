//package com.test.springboot.controller;
//
//import com.test.springboot.entity.User;
//import com.test.springboot.service.UserService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
///**
// * @date : 2018/10/31 17:08
// * @author: liangenmao
// */
//@RestController
//public class T {
//    @Autowired
//    private UserService userService;
//    @GetMapping(name = "/test4")
//    public Object test4(String username, String password, HttpServletRequest request) {
////        if (username == null || password == null)
////            return "用户名和密码不能为空";
////        Subject subject = SecurityUtils.getSubject();
////        if (subject != null && subject.isAuthenticated())
////            return "已登录";
////        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
////        //进行验证，这里可以捕获异常，然后返回对应信息
////        try {
////            assert subject != null;
////            subject.login(usernamePasswordToken);
////        } catch (Exception e) {
////            return e.getMessage();
////        }
////        //保存最后一次登录相关信息
////        User user = (User) subject.getPrincipal();
////        user.setId(user.getId());
////        user.setLastLoginDate(new Date());
////        user.setLastLoginIp(request.getRemoteAddr());
////        if (userService.updateById(user))
////            return "登录成功";
////        return "登录成功,但最后一次登录信息保存失败";
//        return "T";
//    }
//}
