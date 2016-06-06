package com.stq.realm.service.security;

import com.stq.constant.ConstantElement;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6.
 */
public class StqSecurityUtil {
    /**
     * 登录的认证
     * @param sessionKey      存储的session的key
     * @param loginName       登录名称
     * @param password        登录密码
     * @param remeberMe       自动登录
     * @return     返回session的信息
     */
    public static Map login(String sessionKey,String loginName,String password,boolean remeberMe){
        Subject subject = SecurityUtils.getSubject();
        Map<String,Object> map  = new HashMap<String, Object>();
        if(subject.getSession().getAttribute(sessionKey)!=null){//说明session未失效
            map.put(ConstantElement.SESSIONISINVALID,true);//标示session是否失效
            map.put(ConstantElement.SESSIONVALUE, subject.getSession().getAttribute(sessionKey));
        }else {//说明session失效了
            map.put(ConstantElement.SESSIONISINVALID,false);//标示session是否失效
            if(!subject.isAuthenticated() && subject.isRemembered()){//自动登录

            }else{//重新登录
                UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
                if(remeberMe){
                    token.setRememberMe(remeberMe);
                }
                subject.login(token);
                if(subject.isAuthenticated()){//认证成功

                }
            }
        }
        return map;
    }

    /**
     * 填充session
     * @param sessionValue
     */
    public static void setSession(Object sessionValue){
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute(ConstantElement.SESSIONKEY,sessionValue);
    }

    /**
     * 获取session
     * @param <T>
     * @return
     */
    public static <T> T getSession(Class<T> clazz){
        Subject subject = SecurityUtils.getSubject();
        return (T) subject.getSession().getAttribute(ConstantElement.SESSIONKEY);
    }

    /**
     * 登出
     */
    public static void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
