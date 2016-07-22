package com.stq.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作用：当用户用直接输入URL进行访问时，如果这个连接有session，则判断是否登录，如果没有登录则直接跳转到登陆页面<br/>
 *      如果这个连接没有session，则直接放行
 * Created by tianqiang.shao on 2016/6/3.
 */
public class SessionHandlerInterceptor  implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {

    }
}
