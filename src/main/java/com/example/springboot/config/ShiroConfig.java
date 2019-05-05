package com.example.springboot.config;

import com.example.springboot.shiro.MyPasswordMatcher;
import com.example.springboot.shiro.MyShiroFilter;
import com.example.springboot.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date : 2018/10/19 15:40
 * @author: liangenmao
 */
@Configuration
public class ShiroConfig {
    @Bean
    public MyPasswordMatcher myPasswordMatcher() {
        return new MyPasswordMatcher();
    }

//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");//散列算法:MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512等。
//        hashedCredentialsMatcher.setHashIterations(1);//散列的次数，默认1次， 设置两次相当于 md5(md5(""));
//        return hashedCredentialsMatcher;
//    }

    @Bean
    public UserRealm myUserRealm(@Qualifier("myPasswordMatcher") MyPasswordMatcher myPasswordMatcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(myPasswordMatcher);
        return userRealm;
    }

    @Bean
    public SecurityManager securityManager(@Qualifier("myUserRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //自定义shiro过滤器
        Map<String, Filter> filterMap = shiroFilterFactoryBean.getFilters();
        filterMap.put("myauthc", new MyShiroFilter());
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //权限控制
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/", "myauthc");
        map.put("/index.html", "anon");
        map.put("/js/**", "anon");
        map.put("/css/**", "anon");
        map.put("/image/anon/**", "anon");
        map.put("/login", "anon");
        map.put("/anon/**", "anon");
        map.put("/logout", "logout");
        map.put("/admin/**", "roles[admin]");
        map.put("/swagger-ui.html#/**","roles[system]");
        map.put("/swagger-ui.html#!/**","roles[system]");
        map.put("/swagger-ui.html","roles[system]");
        map.put("/swagger-ui.html#/","roles[system]");
        map.put("/druid/**","roles[system]");
        map.put("/userandadmin/**", "roles[admin,user]");
        //对所有用户认证
        map.put("/**", "authc");
        //登录页面
        shiroFilterFactoryBean.setLoginUrl("/index.html");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/use_ center.html");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/index.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
