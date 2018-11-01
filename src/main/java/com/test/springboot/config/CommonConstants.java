package com.test.springboot.config;

/**
 * @date : 2018/10/17 15:21
 * @author: liangenmao
 */
public class CommonConstants {
    //mybatis的mapper路径
//    public static final String MAPPERSCAN = "com.test.springboot.dao";
    /**
     * 过滤器扫描根目录
     */
    public static final String FILTER_SCAN = "com.test.springboot.filter";
    /**
     * 监听器扫描根目录
     */
    public static final String LISTENER_SCAN = "com.test.springboot.listener";
    /**
     * 控制层扫描根目录
     */
    public static final String CONTROLLER_SCAN = "com.test.springboot.controller";
    /**
     * 尝试登录次数
     */
    public static final String LOGIN_ATTEMPTS_NUM = "login_num";
    /**
     * 最大尝试登录次数
     */
    public static final int MAX_LOGIN_ATTEMPTS_NUM = 5;
    /**
     * 尝试登录次数过期时间
     */
    public static final int LOGIN_ATTEMPTS_EXPIRE_TIME = 300;
}
