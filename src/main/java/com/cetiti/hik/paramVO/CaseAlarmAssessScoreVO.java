package com.cetiti.hik.paramVO;

public class CaseAlarmAssessScoreVO {
    private long caseAlarmType;
    private long days;
    private long corpID;
    private String corpName;
    private long evaluatorUserID;
    private String evaluatorUserName;
    private long AJCLCSJGZXBID;
    private long CaseID;
    private long CaseAlarmID;
    private long CASEPROBLEMID;

    public long getCaseID() {
        return CaseID;
    }

    public void setCaseID(long caseID) {
        CaseID = caseID;
    }

    public long getCaseAlarmID() {
        return CaseAlarmID;
    }

    public void setCaseAlarmID(long caseAlarmID) {
        CaseAlarmID = caseAlarmID;
    }

    public long getCASEPROBLEMID() {
        return CASEPROBLEMID;
    }

    public void setCASEPROBLEMID(long CASEPROBLEMID) {
        this.CASEPROBLEMID = CASEPROBLEMID;
    }

    public long getAJCLCSJGZXBID() {
        return AJCLCSJGZXBID;
    }

    public void setAJCLCSJGZXBID(long AJCLCSJGZXBID) {
        this.AJCLCSJGZXBID = AJCLCSJGZXBID;
    }

    public long getCaseAlarmType() {
        return caseAlarmType;
    }

    public void setCaseAlarmType(long caseAlarmType) {
        this.caseAlarmType = caseAlarmType;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public long getCorpID() {
        return corpID;
    }

    public void setCorpID(long corpID) {
        this.corpID = corpID;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public long getEvaluatorUserID() {
        return evaluatorUserID;
    }

    public void setEvaluatorUserID(long evaluatorUserID) {
        this.evaluatorUserID = evaluatorUserID;
    }

    public String getEvaluatorUserName() {
        return evaluatorUserName;
    }

    public void setEvaluatorUserName(String evaluatorUserName) {
        this.evaluatorUserName = evaluatorUserName;
    }
}
