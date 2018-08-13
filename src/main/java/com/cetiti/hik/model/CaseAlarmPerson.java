package com.cetiti.hik.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CASEALARMPERSON")
public class CaseAlarmPerson {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CASEID")
    private Long caseid;

    @Column(name = "EPC")
    private String epc;

    @Column(name = "CASENUMBER")
    private String casenumber;

    @Column(name = "ALARMTIME")
    private Date alarmtime;

    @Column(name = "ISREAD")
    private Long isread;

    @Column(name = "CORPID")
    private Long corpid;

    @Column(name = "CORPNAME")
    private String corpname;

    @Column(name = "STATE")
    private Long state;

    @Column(name = "CASEALARMID")
    private Long casealarmid;

    @Column(name = "ALARMUSERID")
    private Long alarmuserid;

    @Column(name = "ALARMUSERPOLICEID")
    private String alarmuserpoliceid;

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

    @Column(name = "ALARMTYPE")
    private Long alarmtype;

    @Column(name = "CREATOR")
    private Long creator;

    @Column(name = "MODIFIER")
    private Long modifier;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    @Column(name = "MARK")
    private String mark;

    @Column(name = "CaseInfo_ID")
    private Long caseinfoId;

    private String alarmusername;

    private Long dictionarytype;

    @Column(name = "IsCaseChecked")
    private Long iscasechecked;

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
    public String getEpc() {
        return epc;
    }

    /**
     * @param epc
     */
    public void setEpc(String epc) {
        this.epc = epc;
    }

    /**
     * @return CASENUMBER
     */
    public String getCasenumber() {
        return casenumber;
    }

    /**
     * @param casenumber
     */
    public void setCasenumber(String casenumber) {
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
     * @return ISREAD
     */
    public Long getIsread() {
        return isread;
    }

    /**
     * @param isread
     */
    public void setIsread(Long isread) {
        this.isread = isread;
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
    public String getCorpname() {
        return corpname;
    }

    /**
     * @param corpname
     */
    public void setCorpname(String corpname) {
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
     * @return CASEALARMID
     */
    public Long getCasealarmid() {
        return casealarmid;
    }

    /**
     * @param casealarmid
     */
    public void setCasealarmid(Long casealarmid) {
        this.casealarmid = casealarmid;
    }

    /**
     * @return ALARMUSERID
     */
    public Long getAlarmuserid() {
        return alarmuserid;
    }

    /**
     * @param alarmuserid
     */
    public void setAlarmuserid(Long alarmuserid) {
        this.alarmuserid = alarmuserid;
    }

    /**
     * @return ALARMUSERPOLICEID
     */
    public String getAlarmuserpoliceid() {
        return alarmuserpoliceid;
    }

    /**
     * @param alarmuserpoliceid
     */
    public void setAlarmuserpoliceid(String alarmuserpoliceid) {
        this.alarmuserpoliceid = alarmuserpoliceid;
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
    public String getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * @return CaseInfo_ID
     */
    public Long getCaseinfoId() {
        return caseinfoId;
    }

    /**
     * @param caseinfoId
     */
    public void setCaseinfoId(Long caseinfoId) {
        this.caseinfoId = caseinfoId;
    }

    /**
     * @return alarmusername
     */
    public String getAlarmusername() {
        return alarmusername;
    }

    /**
     * @param alarmusername
     */
    public void setAlarmusername(String alarmusername) {
        this.alarmusername = alarmusername;
    }

    /**
     * @return dictionarytype
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
     * @return IsCaseChecked
     */
    public Long getIscasechecked() {
        return iscasechecked;
    }

    /**
     * @param iscasechecked
     */
    public void setIscasechecked(Long iscasechecked) {
        this.iscasechecked = iscasechecked;
    }
}