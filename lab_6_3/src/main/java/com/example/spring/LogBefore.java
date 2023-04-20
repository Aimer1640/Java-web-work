package com.example.spring;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;

public class LogBefore implements MethodBeforeAdvice {

	@Override
	public void before(Method targetMethod, Object[] methodArgs, Object targetClass) throws Throwable {
    	String className = targetClass.getClass().getName();
		String methodName = targetMethod.getName();
		Date date = new Date();
		String curTime = DateFormat.getDateTimeInstance().format(date);
		String logInfo = "【" + curTime + "】：" + className + "." + methodName + "() 方法被调用！";
		System.out.println(logInfo);
    }

}
