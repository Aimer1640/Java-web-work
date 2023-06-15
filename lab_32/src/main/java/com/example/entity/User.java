package com.example.entity;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "t_user")
public class User  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;

    //repassword不映射到数据表
    @Transient
    private  String repasswod;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepasswod() {
        return repasswod;
    }

    public void setRepasswod(String repasswod) {
        this.repasswod = repasswod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
