package com.stq.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串的工具类，此工具类不能包含任何的业务逻辑<br/>
 * 此类继承apache-common-lang中的StringUtils,<br/>
 * 以后项目中凡是用到字符串操作的工具类都必须继承StqStringUtils,<br/>
 * 为了规范，不能直接继承Apache中的StringUtils,如果Apache中的StringUtils<br/>
 * 不存在的可以在StqStringUtils中添加
 * Created by tianqiang.shao on 2016/5/30.
 */
public class StqStringUtils extends StringUtils{
    private static final Log log = LogFactory.getLog(StqStringUtils.class);
    /**
     * 将日期转换成指定格式的字符串，如果formate为空，则默认为"yyyy-MM-dd"
     * @param date      需要转换的日期
     * @param dateFormat   需要转化的格式
     * @return   返回转换后的日期字符串格式
     */
    public static String dateFormatStr(Date date,String dateFormat){
        try{
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            return format.format(date);
        }catch (IllegalArgumentException e){
            log.error(dateFormat+"这种日期格式不正确");
        }
        return null;
    }


}
