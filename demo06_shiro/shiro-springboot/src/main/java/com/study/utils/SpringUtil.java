package com.study.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取容器中的bean
 */
@Component
public  class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    //得到上下文对象
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null){

            SpringUtil.applicationContext  = applicationContext;

        }
    }

    public static ApplicationContext getApplicationContext() {
            return applicationContext;
    }

    //获取bean
    public static Object getBean(String beaname) {
        return getApplicationContext().getBean(beaname);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String beaname,Class<T> clazz) {
        return getApplicationContext().getBean(beaname,clazz);
    }
}
