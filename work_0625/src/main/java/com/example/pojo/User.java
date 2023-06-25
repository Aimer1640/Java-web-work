package com.example.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "t_user")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private String user_name;
    private String user_pwds;
    private String phone;

    private String username;
    private String password;
    private String email;

    //repassword不映射到数据表
    @Transient
    private  String repasswod;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_pwds(String user_pwds) {
        this.user_pwds = user_pwds;
    }

    public String getUser_pwds() {
        return user_pwds;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pwds='" + user_pwds + '\'' +

                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

}