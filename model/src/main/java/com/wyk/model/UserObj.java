package com.wyk.model;

import java.io.Serializable;

/**
 * 用户类型
 * Created by wyk on 2015/12/3.
 */


@SuppressWarnings("serial")
public class UserObj implements Serializable {
    //{"id":1,"username":"wyk123","password":"123456","name":"浅浅de想你","imghead":"wyk123.jpg","registerday":"2015-07-22 "}

    private int id;
    private String username;
    private String password;
    private String name;
    private String imghead;
    private String registerday;

    @Override
    public String toString() {
        return "UserObj{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", imghead='" + imghead + '\'' +
                ", registerday='" + registerday + '\'' +
                '}';
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImghead() {
        return imghead;
    }

    public void setImghead(String imghead) {
        this.imghead = imghead;
    }

    public String getRegisterday() {
        return registerday;
    }

    public void setRegisterday(String registerday) {
        this.registerday = registerday;
    }
}
