package com.cetiti.hik.model;

import java.util.Date;

public class CaseEarlyDecisionResult {
    private int id;

    private String decisionresult;

    private String decideresultname;

    private int state;

    private int caseearlywarningid;

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

    public String getDecisionresult() {
        return decisionresult;
    }

    public void setDecisionresult(String decisionresult) {
        this.decisionresult = decisionresult;
    }

    public String getDecideresultname() {
        return decideresultname;
    }

    public void setDecideresultname(String decideresultname) {
        this.decideresultname = decideresultname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCaseearlywarningid() {
        return caseearlywarningid;
    }

    public void setCaseearlywarningid(int caseearlywarningid) {
        this.caseearlywarningid = caseearlywarningid;
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