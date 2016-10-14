package com.stq.interceptors;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by stq on 16-9-29.
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = String.valueOf(super.getAvailablePrincipal(principals));
        System.out.println(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(null!=userName && "jadyer".equals(userName)){
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
            info.addRole("admin");
            //添加权限
            info.addStringPermission("admin:manage");
            System.out.println("已为用户[jadyer]赋予了[admin]角色和[admin:manage]权限");
            return info;
        }else if(null!=userName && "玄玉".equals(userName)){
            System.out.println("当前用户[玄玉]无授权");
            return info;
        }else if(null!=userName && "aa".equals(userName)){
            System.out.println("当前用户[aa]无授权");
            return info;
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authToken;
        return null;

    }
}
