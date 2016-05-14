package com.wyk.model;

import java.io.Serializable;

/**
 * Created by wyk on 2016/5/12.
 */
public class QuestionObj implements Serializable {
    int id = -1;
    String title;
    String ansa;
    String ansb;
    String ansc;
    String ansd;
    String ans;
    int type;
    int groupid;
    String groupname;
    String createtime;

    public String getStringType(){
        switch (type){
            case 1:
                return "(c/c++)";
            case 2:
                return "(java)";
            case 3:
                return "(数据结构)";
            case 4:
                return "(计算机基础)";
        }
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnsa() {
        return ansa;
    }

    public void setAnsa(String ansa) {
        this.ansa = ansa;
    }

    public String getAnsb() {
        return ansb;
    }

    public void setAnsb(String ansb) {
        this.ansb = ansb;
    }

    public String getAnsc() {
        return ansc;
    }

    public void setAnsc(String ansc) {
        this.ansc = ansc;
    }

    public String getAnsd() {
        return ansd;
    }

    public void setAnsd(String ansd) {
        this.ansd = ansd;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
