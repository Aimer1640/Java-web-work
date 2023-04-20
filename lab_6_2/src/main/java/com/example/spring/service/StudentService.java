package com.example.spring.service;

public interface StudentService {

	void save(String stuNumber, String stuName);
	void update(String stuNumber, String stuName);
	void delete(String stuNumber);
}
