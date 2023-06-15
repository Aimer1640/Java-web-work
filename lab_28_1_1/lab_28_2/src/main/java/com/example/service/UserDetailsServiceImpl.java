package com.example.service;

import com.example.pojo.Authority;
import com.example.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
//2040706101 杨艾琳
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private  PersonService personService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person=personService.findPersonByAccount(username);
        List<Authority> authorities=personService.findAuthoritiesByAccount(username);
        List<SimpleGrantedAuthority> authorityList=authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());
        UserDetails userDetails=new User(person.getAccount(),person.getPassword(),authorityList);
        return userDetails;
    }
}
