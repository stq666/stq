package com.stq.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.stq.constant.ConstantElement;
import com.stq.model.SysUser;
import com.stq.modelVo.ReturnMessage;
import com.stq.modelVo.system.SysUserVo;
import com.stq.realm.service.security.StqSecurityUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * web登录的控制类
 * Created by tianqiang.shao on 2016/6/3.
 */
@Controller
@RequestMapping("/security")
public class LoginController {
    private static final Log log = LogFactory.getLog(LoginController.class);

    /**
     * 登录
     * @param vo
     * @param request
     * @param response
     * @return
     */
    public @ResponseBody JSONObject login(@ModelAttribute SysUserVo vo,HttpServletRequest request,HttpServletResponse response){
        JSONObject result=null;
        try {
            Map<String,Object>map = StqSecurityUtil.login(ConstantElement.SESSIONKEY, vo.getLoginName(), vo.getPassword(),false);
            if(map!=null && map.size()>0){
                boolean sessionIsInvalid = Boolean.valueOf(String.valueOf(map.get(ConstantElement.SESSIONISINVALID)));
                if(sessionIsInvalid){//没有失效
                    SysUserVo sysUser = (SysUserVo)map.get(ConstantElement.SESSIONVALUE);
                    result= ReturnMessage.getResult(true, sysUser, null, null);
                }else{//已经失效了
                    SysUserVo sysUser = new SysUserVo();
                    // TODO 向sysUser中添加权限，角色等等内容

                    //把sysUser添加到session中
                    StqSecurityUtil.setSession(sysUser);
                }
            }
        }catch (Exception e){
            log.error("登录时出现了异常:"+e);
            result = ReturnMessage.getResult(true,null,"登陆时服务器出现失败",ConstantElement.SERVERERRORCODE);
        }finally {
            return result;
        }
    }

    /**
     * 退出登录
     * @return
     */
    public @ResponseBody JSONObject logout(){
        JSONObject result=null;
        try{
            StqSecurityUtil.logout();
            result = ReturnMessage.getResult(true,ConstantElement.SERVERSUCCESSCODE,null,null);
        }catch (Exception e){
            log.error("退出时出现了异常:"+e);
            result = ReturnMessage.getResult(true,null,"退出时服务器出现失败",ConstantElement.SERVERERRORCODE);
        }
        return result;
    }
}
