package com.cetiti.hik.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "MESSAGEPUSH")
public class Messagepush {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "ALARMCONTENT")
    private Object alarmcontent;

    @Column(name = "PUSHSTATE")
    private Long pushstate;

    @Column(name = "ALARMUSERID")
    private String alarmuserid;

    @Column(name = "POLICECODE")
    private Object policecode;

    @Column(name = "DEALAUTHORITY")
    private Long dealauthority;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    @Column(name = "MARK")
    private Object mark;

    @Column(name = "CASENUMBER")
    private Object casenumber;

    @Column(name = "CASEID")
    private String caseid;

    @Column(name = "CASEALARMPERSONID")
    private String casealarmpersonid;

    private long days;
    private String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return ALARMCONTENT
     */
    public Object getAlarmcontent() {
        return alarmcontent;
    }

    /**
     * @param alarmcontent
     */
    public void setAlarmcontent(Object alarmcontent) {
        this.alarmcontent = alarmcontent;
    }

    /**
     * @return PUSHSTATE
     */
    public Long getPushstate() {
        return pushstate;
    }

    /**
     * @param pushstate
     */
    public void setPushstate(Long pushstate) {
        this.pushstate = pushstate;
    }

    /**
     * @return ALARMUSERID
     */
    public String getAlarmuserid() {
        return alarmuserid;
    }

    /**
     * @param alarmuserid
     */
    public void setAlarmuserid(String alarmuserid) {
        this.alarmuserid = alarmuserid;
    }

    /**
     * @return POLICECODE
     */
    public Object getPolicecode() {
        return policecode;
    }

    /**
     * @param policecode
     */
    public void setPolicecode(Object policecode) {
        this.policecode = policecode;
    }

    /**
     * @return DEALAUTHORITY
     */
    public Long getDealauthority() {
        return dealauthority;
    }

    /**
     * @param dealauthority
     */
    public void setDealauthority(Long dealauthority) {
        this.dealauthority = dealauthority;
    }

    /**
     * @return CREATETIME
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return MODIFYTIME
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * @param modifytime
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    /**
     * @return MARK
     */
    public Object getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(Object mark) {
        this.mark = mark;
    }

    /**
     * @return CASENUMBER
     */
    public Object getCasenumber() {
        return casenumber;
    }

    /**
     * @param casenumber
     */
    public void setCasenumber(Object casenumber) {
        this.casenumber = casenumber;
    }

    /**
     * @return CASEID
     */
    public String getCaseid() {
        return caseid;
    }

    /**
     * @param caseid
     */
    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    /**
     * @return CASEALARMPERSONID
     */
    public String getCasealarmpersonid() {
        return casealarmpersonid;
    }

    /**
     * @param casealarmpersonid
     */
    public void setCasealarmpersonid(String casealarmpersonid) {
        this.casealarmpersonid = casealarmpersonid;
    }
}