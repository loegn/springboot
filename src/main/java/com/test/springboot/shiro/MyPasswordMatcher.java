package com.test.springboot.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
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
        if (submittedPassword.toString().equals(storedCredentials.toString()))
            return true;
        return false;
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
