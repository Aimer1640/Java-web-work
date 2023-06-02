package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassRepository extends CrudRepository<Class,Integer> {
    List<Class> findClassesByClassNameContains(String className);
}
