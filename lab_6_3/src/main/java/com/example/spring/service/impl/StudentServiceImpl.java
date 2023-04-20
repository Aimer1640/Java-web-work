package com.example.spring.service.impl;

import com.example.spring.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public boolean delete(String stuNumber) {
		System.out.print("执行 delete 业务方法!");
		System.out.println("学号是 " + stuNumber + " 的学生被删除");
		return true;
	}

	public boolean save(String stuNumber, String stuName) {
		System.out.print("执行 save 业务方法!");
		System.out.println("增加的学生学号是：" + stuNumber + ", 姓名是：" + stuName);
		return true;
	}

	public boolean update(String stuNumber, String stuName) {
		System.out.print("执行 update 业务方法!");
		System.out.println("修改的学生学号是：" + stuNumber + ", 修改后的姓名是：" + stuName);
		return true;
	}

}
