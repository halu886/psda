package com.jxufe.halu.psda.pojo;

import java.util.Date;

public class FileEdition {
    private Short editionid;

    private String fileid;

    private String filename;

    private String filepath;

    private Date uploadtime;

    public Short getEditionid() {
        return editionid;
    }

    public void setEditionid(Short editionid) {
        this.editionid = editionid;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
}