package com.test.springboot.controller;

import com.test.springboot.pojo.User;
import com.test.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//@Controller
@RestController
public class MyController {
    private final UserService userService;

    @Autowired
    public MyController(UserService userService, JedisConnectionFactory jedisConnectionFactory) {
        this.userService = userService;
        this.jedisConnectionFactory = jedisConnectionFactory;
    }
//    public static final Logger log = LoggerFactory.getLogger(MyController.class);

/*    //错误页面展示
    @RequestMapping("/error")
    public String error(){
        return "error ok!";
    }*/

    @RequestMapping("/login")
    public Object login(String username, String password, HttpServletRequest request) {
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
        User user = (User) subject.getPrincipal();
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

    @RequestMapping("/test/q")
    public Object testTwo() {
        return true;
    }

    @RequestMapping("/test/w")
    public Object testOne() {
        System.out.println("start");
        System.out.println("end");
        return true;
    }

    private final JedisConnectionFactory jedisConnectionFactory;

    @RequestMapping("/redis")
    public Object testRedis() {
        //得到一个连接
        RedisConnection conn = jedisConnectionFactory.getConnection();
        conn.set("hello".getBytes(), "world".getBytes());
        return new String(Objects.requireNonNull(conn.get("hello".getBytes())));
    }

    @RequestMapping("/throwError")
    public Object throwError() {
        throw new RuntimeException("出错了");
    }

    @RequestMapping("/json")
    public Object json(){
        Map<String, java.io.Serializable> map = new HashMap<>();
        map.put("int",1);
        map.put("boolean",true);
        map.put("string","jsonp");
        return map;
    }
}
