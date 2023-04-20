package com.example.spring.service.impl;

import com.example.spring.service.StudentService;

public class StudentServiceImpl implements StudentService {
	@Override
	public void delete(String stuNumber) {
		System.out.println("学号是 " + stuNumber + " 的学生被删除");
	}

	@Override
	public void save(String stuNumber, String stuName) {
		System.out.println("增加的学生学号是：" + stuNumber + ", 姓名是：" + stuName);
	}

	@Override
	public void update(String stuNumber, String stuName) {
		System.out.println("修改的学生学号是：" + stuNumber + ", 修改后的姓名是：" + stuName);
//		System.out.println(1/0);
	}

}
