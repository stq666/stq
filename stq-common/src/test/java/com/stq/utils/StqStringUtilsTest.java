package com.stq.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/30.
 */
public class StqStringUtilsTest {
    @Test
    public void dateFormatStrTest(){
        String dateFormatStr = StqStringUtils.dateFormatStr(new Date(), "yyyy-MM-dd");
        Assert.assertNotNull(dateFormatStr);
        String dateFormatStr1 = StqStringUtils.dateFormatStr(new Date(), "yyyy-MM-dd HH");
        Assert.assertNotNull(dateFormatStr1);
    }

}
