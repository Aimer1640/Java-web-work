package com.example.respository;

import com.example.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person,Integer> {
    public Person findByAccount(String account);
}
