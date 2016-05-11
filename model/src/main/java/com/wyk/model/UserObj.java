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
    private String nickname;
    private String imghead;
    private int sex;
    private String phone;
    private String birthday;
    private String introduction;
    private String registerday;

    @Override
    public String toString() {
        return "UserObj{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", imghead='" + imghead + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", introduction='" + introduction + '\'' +
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        sex = sex;
    }

    public String getImghead() {
        return imghead;
    }

    public void setImghead(String imghead) {
        this.imghead = imghead;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRegisterday() {
        return registerday;
    }

    public void setRegisterday(String registerday) {
        this.registerday = registerday;
    }
}
