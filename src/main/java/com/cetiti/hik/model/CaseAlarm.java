package com.cetiti.hik.model;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "CASEALARM")
public class CaseAlarm {
    @Column(name = "ID")
    private Long id;

    @Column(name = "CASEID")
    private Long caseid;

    @Column(name = "EPC")
    private Object epc;

    @Column(name = "CASENUMBER")
    private Object casenumber;

    @Column(name = "ALARMTIME")
    private Date alarmtime;

    @Column(name = "ALARMTYPE")
    private Long alarmtype;

    @Column(name = "ISALARM")
    private Long isalarm;

    @Column(name = "CORPID")
    private Long corpid;

    @Column(name = "CORPNAME")
    private Object corpname;

    @Column(name = "STATE")
    private Long state;

    @Column(name = "CASEEARLYWARNINGID")
    private Long caseearlywarningid;

    @Column(name = "WARNINGTIME")
    private Date warningtime;

    @Column(name = "ENDALARMTIME")
    private Date endalarmtime;

    @Column(name = "ALARMSTATE")
    private Long alarmstate;

    @Column(name = "EARLYDECISIONRESULTID")
    private Long earlydecisionresultid;

    @Column(name = "CREATOR")
    private Long creator;

    @Column(name = "MODIFIER")
    private Long modifier;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    @Column(name = "MARK")
    private Object mark;

    @Column(name = "AJJBXX_ID")
    private Long ajjbxxId;

    @Column(name = "ALARMCONTENT")
    private Object alarmcontent;

    @Column(name = "CASECHECKED")
    private Long casechecked;

    @Column(name = "CASECHECKEDINFO")
    private Object casecheckedinfo;

    @Column(name = "CASECHECKEDDATE")
    private Date casecheckeddate;

    @Column(name = "CASECHECKEDUSERID")
    private Long casecheckeduserid;

    @Column(name = "CASECHECKEDUSERNAME")
    private Object casecheckedusername;

    @Column(name = "DICTIONARYTYPE")
    private Long dictionarytype;

    @Column(name = "FEEDBACKINFO")
    private Object feedbackinfo;

    @Column(name = "FEEDBACKDATE")
    private Date feedbackdate;

    @Column(name = "FEEDBACKUSERID")
    private Long feedbackuserid;

    @Column(name = "FEEDBACKUSERNAME")
    private Object feedbackusername;

    private long caseproblemid;

    public long getCaseproblemid() {
        return caseproblemid;
    }

    public void setCaseproblemid(long caseproblemid) {
        this.caseproblemid = caseproblemid;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return CASEID
     */
    public Long getCaseid() {
        return caseid;
    }

    /**
     * @param caseid
     */
    public void setCaseid(Long caseid) {
        this.caseid = caseid;
    }

    /**
     * @return EPC
     */
    public Object getEpc() {
        return epc;
    }

    /**
     * @param epc
     */
    public void setEpc(Object epc) {
        this.epc = epc;
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
     * @return ALARMTIME
     */
    public Date getAlarmtime() {
        return alarmtime;
    }

    /**
     * @param alarmtime
     */
    public void setAlarmtime(Date alarmtime) {
        this.alarmtime = alarmtime;
    }

    /**
     * @return ALARMTYPE
     */
    public Long getAlarmtype() {
        return alarmtype;
    }

    /**
     * @param alarmtype
     */
    public void setAlarmtype(Long alarmtype) {
        this.alarmtype = alarmtype;
    }

    /**
     * @return ISALARM
     */
    public Long getIsalarm() {
        return isalarm;
    }

    /**
     * @param isalarm
     */
    public void setIsalarm(Long isalarm) {
        this.isalarm = isalarm;
    }

    /**
     * @return CORPID
     */
    public Long getCorpid() {
        return corpid;
    }

    /**
     * @param corpid
     */
    public void setCorpid(Long corpid) {
        this.corpid = corpid;
    }

    /**
     * @return CORPNAME
     */
    public Object getCorpname() {
        return corpname;
    }

    /**
     * @param corpname
     */
    public void setCorpname(Object corpname) {
        this.corpname = corpname;
    }

    /**
     * @return STATE
     */
    public Long getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Long state) {
        this.state = state;
    }

    /**
     * @return CASEEARLYWARNINGID
     */
    public Long getCaseearlywarningid() {
        return caseearlywarningid;
    }

    /**
     * @param caseearlywarningid
     */
    public void setCaseearlywarningid(Long caseearlywarningid) {
        this.caseearlywarningid = caseearlywarningid;
    }

    /**
     * @return WARNINGTIME
     */
    public Date getWarningtime() {
        return warningtime;
    }

    /**
     * @param warningtime
     */
    public void setWarningtime(Date warningtime) {
        this.warningtime = warningtime;
    }

    /**
     * @return ENDALARMTIME
     */
    public Date getEndalarmtime() {
        return endalarmtime;
    }

    /**
     * @param endalarmtime
     */
    public void setEndalarmtime(Date endalarmtime) {
        this.endalarmtime = endalarmtime;
    }

    /**
     * @return ALARMSTATE
     */
    public Long getAlarmstate() {
        return alarmstate;
    }

    /**
     * @param alarmstate
     */
    public void setAlarmstate(Long alarmstate) {
        this.alarmstate = alarmstate;
    }

    /**
     * @return EARLYDECISIONRESULTID
     */
    public Long getEarlydecisionresultid() {
        return earlydecisionresultid;
    }

    /**
     * @param earlydecisionresultid
     */
    public void setEarlydecisionresultid(Long earlydecisionresultid) {
        this.earlydecisionresultid = earlydecisionresultid;
    }

    /**
     * @return CREATOR
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @return MODIFIER
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * @param modifier
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
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
     * @return AJJBXX_ID
     */
    public Long getAjjbxxId() {
        return ajjbxxId;
    }

    /**
     * @param ajjbxxId
     */
    public void setAjjbxxId(Long ajjbxxId) {
        this.ajjbxxId = ajjbxxId;
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
     * @return CASECHECKED
     */
    public Long getCasechecked() {
        return casechecked;
    }

    /**
     * @param casechecked
     */
    public void setCasechecked(Long casechecked) {
        this.casechecked = casechecked;
    }

    /**
     * @return CASECHECKEDINFO
     */
    public Object getCasecheckedinfo() {
        return casecheckedinfo;
    }

    /**
     * @param casecheckedinfo
     */
    public void setCasecheckedinfo(Object casecheckedinfo) {
        this.casecheckedinfo = casecheckedinfo;
    }

    /**
     * @return CASECHECKEDDATE
     */
    public Date getCasecheckeddate() {
        return casecheckeddate;
    }

    /**
     * @param casecheckeddate
     */
    public void setCasecheckeddate(Date casecheckeddate) {
        this.casecheckeddate = casecheckeddate;
    }

    /**
     * @return CASECHECKEDUSERID
     */
    public Long getCasecheckeduserid() {
        return casecheckeduserid;
    }

    /**
     * @param casecheckeduserid
     */
    public void setCasecheckeduserid(Long casecheckeduserid) {
        this.casecheckeduserid = casecheckeduserid;
    }

    /**
     * @return CASECHECKEDUSERNAME
     */
    public Object getCasecheckedusername() {
        return casecheckedusername;
    }

    /**
     * @param casecheckedusername
     */
    public void setCasecheckedusername(Object casecheckedusername) {
        this.casecheckedusername = casecheckedusername;
    }

    /**
     * @return DICTIONARYTYPE
     */
    public Long getDictionarytype() {
        return dictionarytype;
    }

    /**
     * @param dictionarytype
     */
    public void setDictionarytype(Long dictionarytype) {
        this.dictionarytype = dictionarytype;
    }

    /**
     * @return FEEDBACKINFO
     */
    public Object getFeedbackinfo() {
        return feedbackinfo;
    }

    /**
     * @param feedbackinfo
     */
    public void setFeedbackinfo(Object feedbackinfo) {
        this.feedbackinfo = feedbackinfo;
    }

    /**
     * @return FEEDBACKDATE
     */
    public Date getFeedbackdate() {
        return feedbackdate;
    }

    /**
     * @param feedbackdate
     */
    public void setFeedbackdate(Date feedbackdate) {
        this.feedbackdate = feedbackdate;
    }

    /**
     * @return FEEDBACKUSERID
     */
    public Long getFeedbackuserid() {
        return feedbackuserid;
    }

    /**
     * @param feedbackuserid
     */
    public void setFeedbackuserid(Long feedbackuserid) {
        this.feedbackuserid = feedbackuserid;
    }

    /**
     * @return FEEDBACKUSERNAME
     */
    public Object getFeedbackusername() {
        return feedbackusername;
    }

    /**
     * @param feedbackusername
     */
    public void setFeedbackusername(Object feedbackusername) {
        this.feedbackusername = feedbackusername;
    }

    @Override
    public String toString() {
        return "CaseAlarm{" +
                "id=" + id +
                ", caseid=" + caseid +
                ", epc=" + epc +
                '}';
    }
}