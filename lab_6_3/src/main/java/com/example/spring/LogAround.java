package com.example.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {
    //2040706101 杨艾琳
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("开始执行【"+invocation.getMethod().getName()+"】方法");
        //执行目标方法
        Object object=invocation.proceed();
        System.out.println("结束执行【"+invocation.getMethod().getName()+"】方法");
        return object;
    }
}
