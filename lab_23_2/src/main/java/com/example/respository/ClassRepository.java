package com.example.respository;

import com.example.pojo.Class;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassRepository extends CrudRepository<Class,Integer> {
    Class findClassesByClassName(String className);
}
