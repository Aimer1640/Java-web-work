package com.example.spring;

import org.springframework.aop.ThrowsAdvice;

public class LogThrow implements ThrowsAdvice {

	public void afterThrowing(Exception e) throws Throwable{
		System.out.println("有异常抛出!");
	}
}
