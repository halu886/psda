package com.jxufe.halu.psda.pojo;

public class Keywords {
    private String keyword;

    private Short editionid;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Short getEditionid() {
        return editionid;
    }

    public void setEditionid(Short editionid) {
        this.editionid = editionid;
    }
}