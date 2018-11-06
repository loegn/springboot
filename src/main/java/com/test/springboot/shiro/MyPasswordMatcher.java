package com.test.springboot.shiro;

import com.test.springboot.entity.User;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.credential.PasswordMatcher;

/**
 * @date : 2018/10/23 11:06
 * @author: liangenmao
 */
public class MyPasswordMatcher extends PasswordMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        Object submittedPassword = getSubmittedPassword(token);
        Object storedCredentials = getStoredPassword(info);
        User user = (User) info.getPrincipals().getPrimaryPrincipal();
        String password = PasswordUtils.encryptPassword(submittedPassword.toString(), user.getSalt(), user.getHashIterations());
        if (!storedCredentials.toString().equals(password))
            throw new IncorrectCredentialsException("用户名或密码不正确");
        else
            return true;
    }

    @Override
    protected Object getSubmittedPassword(AuthenticationToken token) {
        Object submit = super.getSubmittedPassword(token);
        if (submit instanceof char[]) {
            submit = String.valueOf((char[]) submit);
        }
        return submit;
    }

    @Override
    protected Object getStoredPassword(AuthenticationInfo storedUserInfo) {
        Object stored = super.getStoredPassword(storedUserInfo);

        if (stored instanceof char[]) {
            stored = String.valueOf((char[]) stored);
        }
        return stored;
    }

}
