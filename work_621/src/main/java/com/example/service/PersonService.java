package com.example.service;

import com.example.pojo.Authority;
import com.example.pojo.Person;
import com.example.respository.AuthorityRepository;
import com.example.respository.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRespository personRespository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    //2040706101 杨艾琳
    public Person findPersonByAccount(String account){
        Person person=null;
        Object object=redisTemplate.opsForValue().get("person_"+account);
        if (object!=null){
            person=(Person) object;
        }else {
            person=personRespository.findByAccount(account);
            if (person!=null){
                redisTemplate.opsForValue().set("person_"+account,person);
            }
        }
        return person;
    }

    public List<Authority> findAuthoritiesByAccount(String account){
        List<Authority> authorities=null;
        Object object=redisTemplate.opsForValue().get("authorities_"+account);
        if (object!=null){
            authorities=(List<Authority>) object;
        }else {
            authorities=authorityRepository.findAuthoritiesByAccount(account);
            if (authorities!=null){
                redisTemplate.opsForValue().set("authorities_"+account,authorities);
            }
        }
        return authorities;
    }

}
