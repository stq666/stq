package com.stq.realm.service.security;

import com.stq.utils.StqStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * Created by Administrator on 2016/6/6.
 */
public class StqSecurityUtil {
    /**
     * 登录的认证
     * @param t               session
     * @param sessionKey      存储的session的key
     * @param loginName       登录名称
     * @param password        登录密码
     * @param remeberMe       自动登录
     * @param <T>
     * @return     返回session的信息
     */
    public static <T>T login(T t,String sessionKey,String loginName,String password,boolean remeberMe){
        Subject subject = SecurityUtils.getSubject();
        if(subject.getSession().getAttribute(sessionKey)!=null){//说明session未失效
            return  (T)subject.getSession().getAttribute(sessionKey);
        }else {//说明session失效了
            if(!subject.isAuthenticated() && subject.isRemembered()){//自动登录

            }else{//重新登录
                UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
                if(remeberMe){
                    token.setRememberMe(remeberMe);
                }
                subject.login(token);
                if(subject.isAuthenticated()){//认证成功
                    return t;
                }
            }
        }
        return null;
    }

    /**
     * 登出
     */
    public static void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
