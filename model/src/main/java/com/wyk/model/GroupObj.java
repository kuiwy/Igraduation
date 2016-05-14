package com.wyk.model;

import java.io.Serializable;

/**
 * Created by wyk on 2016/5/13.
 */
public class GroupObj implements Serializable {
    private int groupid;
    private String groupname;
    private int type;
    private int num;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
