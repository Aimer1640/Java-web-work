package com.example.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyInterceptor {
	@Pointcut("execution(* com.example.spring.service.*.*(..))")
	private  void myPointCut(){};
    //2040706101 杨艾琳
	@Before("myPointCut()")
	public void beforeDo(){
		System.out.println("[前置通知]");
	}

	@After("myPointCut()")
	public void afterDo(){
		System.out.println("[最终通知]");
	}

	@AfterReturning("myPointCut()")
	public void returnDo(){
		System.out.println("[后置通知]");
	}

	@AfterThrowing("myPointCut()")
	public void exceptionDo(){
		System.out.println("[异常通知]方法抛出异常");
	}

	@Around("myPointCut()")
	public void aroundDo(ProceedingJoinPoint pjp) throws Throwable{
		//ProceedingJoinPoint的getSignature()方法用于获取切入点
		System.out.println("环绕通知:开始执行[" + pjp.getSignature().getName() + "]方法！");
		Object res=null;
		res=pjp.proceed();
		System.out.println("环绕通知:结束执行[" + pjp.getSignature().getName() + "]方法！"); 
	}

}
