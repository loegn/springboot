package com.test.springboot.shiro;


import com.test.springboot.entity.Permission;
import com.test.springboot.entity.Role;
import com.test.springboot.entity.User;
import com.test.springboot.service.PermissionService;
import com.test.springboot.service.RoleService;
import com.test.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @date : 2018/10/19 15:38
 * @author: liangenmao
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.getByUsername(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roleList = roleService.getByUserId(user.getId());
        for (Role role : roleList){
            info.addRole(role.getRoleName());
            for (Permission permission : permissionService.getByRoleId(role.getId()))
                info.addStringPermission(permission.getPermissionName());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken myToken = (UsernamePasswordToken) token;
        String username = myToken.getUsername();
        String password = new String(myToken.getPassword());
        User user = userService.getByUsername(username);
        if (user == null)
            throw new UnknownAccountException("用户名或密码不正确");
        if (!user.getPassword().equals(password))
            throw new IncorrectCredentialsException("用户名或密码不正确");
        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
