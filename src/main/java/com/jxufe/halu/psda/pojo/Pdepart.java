package com.jxufe.halu.psda.pojo;

public class Pdepart {
    private String departid;

    private String departname;

    private String pdepartid;

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid == null ? null : departid.trim();
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    public String getPdepartid() {
        return pdepartid;
    }

    public void setPdepartid(String pdepartid) {
        this.pdepartid = pdepartid == null ? null : pdepartid.trim();
    }
}