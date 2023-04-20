package com.example.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
//    2040706101 杨艾琳
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //权限验证 前置增强
        checkPermissions("0");
        //执行目标方法
        Object object=invocation.proceed();
        //日志记录 后置增强
        log();
        return object;
    }
    //模拟教务员权限验证方法
    public void checkPermissions(String role){
        if (role.equals("0")){
            System.out.println("教务员登录成功！");
        }
        else {
            System.out.println("管理员登录成功！");
        }
    }
    //模拟教务员日志记录
    public void log(){
        System.out.println("记录日志成功！");
    }
}
