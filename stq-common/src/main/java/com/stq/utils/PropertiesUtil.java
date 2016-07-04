package com.stq.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties的工具类
 * Created by stq on 16-7-1.
 */
public class PropertiesUtil {
    private InputStream in;
    private Properties prop;

    public PropertiesUtil(String resourcePath){
        try {
            in = new FileInputStream(new File(resourcePath));
            prop = new Properties();
            prop.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }

    public String getValue(String key){
        return prop.getProperty(key);
    }
}
