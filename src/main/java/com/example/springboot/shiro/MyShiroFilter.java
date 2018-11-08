package com.example.springboot.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @date : 2018/10/25 08:47
 * @author: liangenmao
 */
public class MyShiroFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response){
//        return super.onAccessDenied(request, response);
        return true;
    }
}
