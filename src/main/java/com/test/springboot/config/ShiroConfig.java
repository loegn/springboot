package com.test.springboot.config;

import com.test.springboot.shiro.MyPasswordMatcher;
import com.test.springboot.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new LinkedHashMap<String, String>();
        //登出
        map.put("/", "anon");
        map.put("/index.html", "anon");
        map.put("/js/**", "anon");
        map.put("/css/**", "anon");
        map.put("/image/anon/**", "anon");
        map.put("/login", "anon");
        map.put("/logout", "logout");
        //对所有用户认证
        map.put("/**", "authc");
        //登录页面
        shiroFilterFactoryBean.setLoginUrl("/index.html");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/use_ center.html");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
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
