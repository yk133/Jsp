package com.yk133.vo;

/**
 * Created by Caiser on 2016/11/30.
 */
public class User {
    private String userid;
    private String name;
    private String pwd;
    private int status;
    static int Now=-1;

    public String getUserid(){return userid;}

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
