package com.example.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name="tb_authority")
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String account;
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
