package com.example.aop;

/**
 * @author Administrator
 */
public class AuthAspect {

	public void validateUser(){
		System.out.println("验证用户！");
	}
	//	2040706101 杨艾琳
	//  before()方法，输出"业务处理之前!"
	public void before(){
		System.out.println("业务处理之前");
	}
	
	//after()方法，输出"业务处理之后!"
	public void after(){
		System.out.println("业务处理之前");
	}


}
