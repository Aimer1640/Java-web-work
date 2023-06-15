package com.example.respository;

import com.example.pojo.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    public List<Authority> findAuthoritiesByAccount(String account);
}
