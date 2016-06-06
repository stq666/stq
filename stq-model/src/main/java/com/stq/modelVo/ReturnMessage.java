package com.stq.modelVo;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回前端的统一类
 * @author tianqiang.shao
 */
public class ReturnMessage {
    /**
     * controller返回的JSONObject
     * @param success      true:返回成功，false：返回失败
     * @param returnObject  返回的内容
     * @param errorMessages 返回的错误消息
     * @param errorCode     返回的代码
     * @return
     */
    public static JSONObject getResult(boolean success,Object returnObject,String errorMessages,String errorCode){
        JSONObject result=new JSONObject();
        JSONObject data=new JSONObject();
        data.put("success",success);
        if(success){
            data.put("returnObject",returnObject);
        }else{
            data.put("errorMessages",errorMessages);
            data.put("errorCode",errorCode);
        }
        result.put("result",data);
        return result;
    }

}
