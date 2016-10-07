package com.jxufe.halu.psda.pojo;

import java.util.Date;

public class Project {
    private String projectid;

    private String pprojectid;

    private String groupid;

    private String departid;

    private String classid;

    private String userid;

    private String projectname;

    private String requirement;

    private String target;

    private String stepplan;

    private String stepdo;

    private String stepcheck;

    private String stepadapt;

    private Short processratio;

    private Date begintime;

    private Date scheduleendtime;

    private Date finishtime;

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getPprojectid() {
        return pprojectid;
    }

    public void setPprojectid(String pprojectid) {
        this.pprojectid = pprojectid == null ? null : pprojectid.trim();
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid == null ? null : departid.trim();
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getStepplan() {
        return stepplan;
    }

    public void setStepplan(String stepplan) {
        this.stepplan = stepplan == null ? null : stepplan.trim();
    }

    public String getStepdo() {
        return stepdo;
    }

    public void setStepdo(String stepdo) {
        this.stepdo = stepdo == null ? null : stepdo.trim();
    }

    public String getStepcheck() {
        return stepcheck;
    }

    public void setStepcheck(String stepcheck) {
        this.stepcheck = stepcheck == null ? null : stepcheck.trim();
    }

    public String getStepadapt() {
        return stepadapt;
    }

    public void setStepadapt(String stepadapt) {
        this.stepadapt = stepadapt == null ? null : stepadapt.trim();
    }

    public Short getProcessratio() {
        return processratio;
    }

    public void setProcessratio(Short processratio) {
        this.processratio = processratio;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getScheduleendtime() {
        return scheduleendtime;
    }

    public void setScheduleendtime(Date scheduleendtime) {
        this.scheduleendtime = scheduleendtime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }
}