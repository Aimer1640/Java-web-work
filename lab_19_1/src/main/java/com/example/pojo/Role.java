package com.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "jiaowuyuan")
public class Role {

  private Integer id;

  @Value("${jiaowuyuan.role}")
  private String role;

  @Value("${jiaowuyuan.roleId}")

  private Integer roleId;

  public Role() {
  }

  @Override
  public String toString() {
    return "Role{" +
            "id=" + id +
            ", role='" + role + '\'' +
            ", roleId=" + roleId +
            '}';
  }
}
