package com.example.pojo;

public class User {
    private String id;
    private String user_name;
    private String user_pwds;
//    private String user_role;

//    public String getUser_role() {
//        return user_role;
//    }
//
//    public void setUser_role(String user_role) {
//        this.user_role = user_role;
//    }

    private String phone;

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