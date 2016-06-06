package com.stq.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.stq.constant.ConstantElement;
import com.stq.model.SysUser;
import com.stq.realm.service.security.StqSecurityUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web登录的控制类
 * Created by tianqiang.shao on 2016/6/3.
 */
@Controller
@RequestMapping("/sect")
public class LoginController {
    private static final Log log = LogFactory.getLog(LoginController.class);

    public @ResponseBody JSONObject login(@ModelAttribute SysUser user,HttpServletRequest request,HttpServletResponse response){
        SysUser login = StqSecurityUtil.login(user, ConstantElement.SESSIONKEY, user.getLoginName(), user.getPassword(),false);
        return null;
    }


}
