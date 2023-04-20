package com.example.service.impl;


import com.example.service.IdentityService;

public class IdentityrServiceImpl implements IdentityService {
	//验证用户合法性
	@Override
	public int addUser(String userName, String password) {
		System.out.println("添加用户");
		return 1;
	}

}
