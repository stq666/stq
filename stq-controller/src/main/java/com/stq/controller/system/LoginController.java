package com.stq.controller.system;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by stq on 16-9-29.
 */
@Controller
@RequestMapping("/stq")
public class LoginController {
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public @ResponseBody
    JSONObject login(@RequestParam("loginName")String loginName, @RequestParam("password")String password, HttpServletRequest request, HttpServletResponse response){
        JSONObject result=null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {//登陆密码错误
            System.out.println("登陆密码错误");
        } catch (ExcessiveAttemptsException e) {//登陆失败次数过多
            System.out.println("登陆失败次数过多");
        } catch (LockedAccountException e) {//账号被锁定
            System.out.println("账号被锁定");
        } catch (DisabledAccountException e) {//账号被禁用
            System.out.println("账号被禁用");
        } catch (ExpiredCredentialsException e) {//账号已过期
            System.out.println("账号已过期");
        } catch (UnknownAccountException e) {//账号不存在
            System.out.println("账号不存在");
        } catch (UnauthorizedException e) {//没有授权
            System.out.println("没有授权");
        }
        return result;
    }
}
