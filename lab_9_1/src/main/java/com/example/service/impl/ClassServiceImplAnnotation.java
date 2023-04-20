package com.example.service.impl;

import com.example.dao.impl.ClassDaoImpl;
import com.example.dao.impl.ClassDaoImplAnnotation;
import com.example.pojo.Class;
import com.example.service.ClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//注解
@Service("classService")
@Transactional

public class ClassServiceImplAnnotation implements ClassService {

    //注解
	@Resource(name = "classDao")
	private ClassDaoImplAnnotation classDao;
	
	public ClassDaoImplAnnotation getClassDao() {
		return classDao;
	}

	public void setClassDao(ClassDaoImplAnnotation userdao) {
		this.classDao = userdao;
	}

    @Override
	public int addClass(Class c) {
		// TODO Auto-generated method stub
		int n=this.classDao.addClass(c);
//		System.out.println(1/0);
		return n;
	}

	@Override
	public int updateClass(Class c) {
		int n=this.classDao.updateClass(c);
		return n;
	}
	//2040706101 杨艾琳
	@Override
	public int deleteClassById(Integer ClassId) {
		int n=this.classDao.deleteClassById(ClassId);
		return n;
	}


	@Override
	public List<Class> findClassByName(String ClassName) {
		// TODO Auto-generated method stub
		List<Class> cs=this.classDao.findClassByName(ClassName);
		return cs;
	}
	//2040706101 杨艾琳
	@Override
	public List<Class> findAllClassByDept(Integer deptId) {
		List<Class> cs=this.classDao.findAllClassByDept(deptId);
		return cs;
	}

	@Override
	public List<Class> findAllClassByMajor(Integer majorId) {
		List<Class> cs=this.classDao.findAllClassByMajor(majorId);
		return cs;
	}


}