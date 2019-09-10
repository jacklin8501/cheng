package com.cheng.as.demo.config.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import lombok.extern.slf4j.Slf4j;

/**
 * UsernamePasswordRealm
 */
@Slf4j
public class UsernamePasswordRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info(":: 授权");
        Object obj = principals.getPrimaryPrincipal();
        log.info(":: Primary Principal : {}", obj.getClass().getName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        roles.add("USER");

        Set<String> perms = new HashSet<>();
        perms.add("USER:EDIT");
        perms.add("ADMIN:EDIT");

        info.setRoles(roles);
        info.setStringPermissions(perms);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info(":: 认证");
        UsernamePasswordToken thisToken = (UsernamePasswordToken) token;
        String username = thisToken.getUsername();
        String password = new String(thisToken.getPassword());
        log.info(":: username : {}, password : {}", username, password);
        return new SimpleAuthenticationInfo(username, password, this.getClass().getName());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return UsernamePasswordToken.class.isInstance(token);
    }
}