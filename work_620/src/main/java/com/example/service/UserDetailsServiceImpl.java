//package com.example.service;
//
//import com.example.pojo.Authority;
//import com.example.pojo.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
////2040706101 杨艾琳
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private  PersonService personService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Person person=personService.findPersonByAccount(username);
//        System.out.println("person:"+person);
//        List<Authority> authorities=personService.findAuthoritiesByAccount(username);
//        System.out.println("auth:"+authorities);
//        List<SimpleGrantedAuthority> authorityList=authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());
//        if(person!=null){
//            UserDetails userDetails=new User(person.getAccount(),person.getPassword(),authorityList);
//            return userDetails;
//        } else {
//            // 如果查询的用户不存在（用户名不存在），必须抛出此异常
//            throw new UsernameNotFoundException("当前用户不存在！");
//        }
//
//
//    }
//}
