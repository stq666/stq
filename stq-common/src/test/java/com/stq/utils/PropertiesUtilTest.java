package com.stq.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by stq on 16-7-4.
 */
public class PropertiesUtilTest {
    @Test
    public void testgetProperties(){
        String path = PropertiesUtilTest.class.getResource("/").getPath()+"/testPropretiesUtil.properties";
        PropertiesUtil cf = new PropertiesUtil(path);
        Assert.assertNotNull(cf);
        Assert.assertEquals("test1",cf.getValue("test1"));
    }
}
