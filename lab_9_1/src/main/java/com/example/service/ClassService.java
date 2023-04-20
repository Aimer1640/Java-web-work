package com.example.service;

import com.example.pojo.Class;

import java.util.List;

public interface ClassService {
	//添加班级
	public int addClass(Class c);

	//更新班级信息
	public int updateClass(Class c);

	//删除班级信息
	public int deleteClassById(Integer class_id);

	//根据班级名称查询班级信息
	public List<Class> findClassByName(String className);

	//查询某个系所有班级信息
	public List<Class> findAllClassByDept(Integer deptId);

	//查询某个专业所有班级信息
	public List<Class> findAllClassByMajor(Integer majorId);
}
