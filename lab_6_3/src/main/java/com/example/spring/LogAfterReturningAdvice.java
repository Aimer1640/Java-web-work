package com.example.spring;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;

public class LogAfterReturningAdvice implements AfterReturningAdvice {
    //2040706101 杨艾琳
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Date date = new Date();
        String curTime = DateFormat.getDateTimeInstance().format(date);
        String logInfo = "【" + curTime + "】：" + method + "() 方法被调用！";
        System.out.println(logInfo);
    }
}
