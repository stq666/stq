package com.stq.controller.system;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by stq on 16-8-30.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof HelloWord){
            if(bean instanceof HelloWord){
                HelloWord w = (HelloWord)bean;
                w.setId(1l);
                w.setName("okok");
            }
            System.out.println("业务处理前．．．．");

        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("业务处理后: "+beanName);
        return null;
    }


}
