package com.test.springboot.shiro;


import com.test.springboot.entity.Permission;
import com.test.springboot.entity.Role;
import com.test.springboot.entity.User;
import com.test.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @date : 2018/10/19 15:38
 * @author: liangenmao
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (user.getRoleList() != null) {
            for (Role role : user.getRoleList()) {
                info.addRole(role.getRoleName());
                if (role.getPermissionList() != null) {
                    for (Permission permission : role.getPermissionList()) {
                        info.addStringPermission(permission.getPermissionName());
                    }
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken myToken = (UsernamePasswordToken) token;
        String username = myToken.getUsername();
        User user = userService.getByUsername(username);
        if (user == null)
            throw new UnknownAccountException("用户名或密码不正确");
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
