package com.example.service.impl;
import java.util.List;
import com.example.dao.impl.ClassDaoImpl;
import com.example.service.ClassService;
import com.example.pojo.Class;

//注解
public class ClassServiceImpl implements ClassService {

    //注解
	private ClassDaoImpl classDao;
	
	public ClassDaoImpl getClassDao() {
		return classDao;
	}

	public void setClassDao(ClassDaoImpl userdao) {
		this.classDao = userdao;
	}

    @Override
	public int addClass(Class c) {
		// TODO Auto-generated method stub
		int n=this.classDao.addClass(c);
		return n;
	}

	@Override
	public int updateClass(Class c) {
		return 0;
	}

	@Override
	public int deleteClassById(Integer class_id) {
		return 0;
	}


	@Override
	public List<Class> findClassByName(String ClassName) {
		// TODO Auto-generated method stub
		List<Class> cs=this.classDao.findClassByName(ClassName);
		return cs;
	}

	@Override
	public List<Class> findAllClassByDept(Integer deptId) {
		return null;
	}

	@Override
	public List<Class> findAllClassByMajor(Integer majorId) {
		return null;
	}


}