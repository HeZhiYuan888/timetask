package com.cetiti.hik.model;


import java.util.Date;

public class CaseEarlyWarning {
    private int id;

    private int type;

    private String name;

    private int casetype;

    private int finishtime;

    private int state;

    private String cancelmsg;

    private Date canceltime;

    private int canceluserid;

    private String cancelusername;

    private int schedulestate;

    private String starttime;

    private String endtime;

    private String decideresult;

    private String decideresultcode;

    private int earlywarningdays;

    private int issuspect;

    private int creator;

    private int modifier;

    private Date createtime;

    private Date modifytime;

    private String mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCasetype() {
        return casetype;
    }

    public void setCasetype(int casetype) {
        this.casetype = casetype;
    }

    public int getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(int finishtime) {
        this.finishtime = finishtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCancelmsg() {
        return cancelmsg;
    }

    public void setCancelmsg(String cancelmsg) {
        this.cancelmsg = cancelmsg;
    }

    public Date getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(Date canceltime) {
        this.canceltime = canceltime;
    }

    public int getCanceluserid() {
        return canceluserid;
    }

    public void setCanceluserid(int canceluserid) {
        this.canceluserid = canceluserid;
    }

    public String getCancelusername() {
        return cancelusername;
    }

    public void setCancelusername(String cancelusername) {
        this.cancelusername = cancelusername;
    }

    public int getSchedulestate() {
        return schedulestate;
    }

    public void setSchedulestate(int schedulestate) {
        this.schedulestate = schedulestate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDecideresult() {
        return decideresult;
    }

    public void setDecideresult(String decideresult) {
        this.decideresult = decideresult;
    }

    public String getDecideresultcode() {
        return decideresultcode;
    }

    public void setDecideresultcode(String decideresultcode) {
        this.decideresultcode = decideresultcode;
    }

    public int getEarlywarningdays() {
        return earlywarningdays;
    }

    public void setEarlywarningdays(int earlywarningdays) {
        this.earlywarningdays = earlywarningdays;
    }

    public int getIssuspect() {
        return issuspect;
    }

    public void setIssuspect(int issuspect) {
        this.issuspect = issuspect;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}