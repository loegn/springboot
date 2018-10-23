package com.test.springboot.controller;

import com.test.springboot.entity.User;
import com.test.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//@Controller
@RestController
public class MyController {
    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }
//    public static final Logger log = LoggerFactory.getLogger(MyController.class);

/*    //错误页面展示
    @RequestMapping("/error")
    public String error(){
        return "error ok!";
    }*/

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        if (username == null || password == null)
            return "用户名和密码不能为空";
        Subject subject = SecurityUtils.getSubject();
        if (subject != null && subject.isAuthenticated())
            return "已登录";
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            assert subject != null;
            subject.login(usernamePasswordToken);
        } catch (Exception e) {
            return e.getMessage();
        }
        //保存最后一次登录相关信息
        User user = userService.getByUsername(username);
        User user1 = new User();
        user1.setId(user.getId());
        user1.setLastLoginDate(new Date());
        user1.setLastLoginIp(request.getRemoteAddr());
        if (userService.updateById(user1))
            return "登录成功";
        return "登录成功,但最后一次登录信息保存失败";
    }

    @RequestMapping("/test")
    public Object test() {
        return true;
    }
}
