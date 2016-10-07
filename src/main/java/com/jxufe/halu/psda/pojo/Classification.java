package com.jxufe.halu.psda.pojo;

public class Classification {
    private String classid;

    private String classname;

    private String pclassid;

    private String userid;

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getPclassid() {
        return pclassid;
    }

    public void setPclassid(String pclassid) {
        this.pclassid = pclassid == null ? null : pclassid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}