package com.cetiti.hik.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CASEALARMASSESSSCORE")
public class Casealarmassessscore {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CASEALARMTYPE")
    private Long casealarmtype;

    @Column(name = "EVALUATORUSERID")
    private Long evaluatoruserid;

    @Column(name = "EVALUATORUSERNAME")
    private String evaluatorusername;

    @Column(name = "EVALUATORCORPID")
    private Long evaluatorcorpid;

    @Column(name = "EVALUATORCORPNAME")
    private String evaluatorcorpname;

    @Column(name = "ASSESSSCORE")
    private double assessscore;

    @Column(name = "ASSESSMULTIPLE")
    private Long assessmultiple;

    @Column(name = "ASSESSTOTAL")
    private double assesstotal;

    @Column(name = "ASSESSDATE")
    private Date assessdate;

    @Column(name = "ASSESSCORPID")
    private Long assesscorpid;

    @Column(name = "ASSESSCORPNAME")
    private String assesscorpname;

    @Column(name = "ASSESSUSERID")
    private Long assessuserid;

    @Column(name = "ASSESSUSERNAME")
    private String assessusername;

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

    @Column(name = "CORPID")
    private Long corpid;

    @Column(name = "CORPNAME")
    private String corpname;

    @Column(name = "CHECKEDTYPE")
    private Long checkedtype;

    @Column(name = "CaseID")
    private Long caseid;

    @Column(name = "CaseAlarmID")
    private Long casealarmid;

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
     * @return CASEALARMTYPE
     */
    public Long getCasealarmtype() {
        return casealarmtype;
    }

    /**
     * @param casealarmtype
     */
    public void setCasealarmtype(Long casealarmtype) {
        this.casealarmtype = casealarmtype;
    }

    /**
     * @return EVALUATORUSERID
     */
    public Long getEvaluatoruserid() {
        return evaluatoruserid;
    }

    /**
     * @param evaluatoruserid
     */
    public void setEvaluatoruserid(Long evaluatoruserid) {
        this.evaluatoruserid = evaluatoruserid;
    }

    /**
     * @return EVALUATORUSERNAME
     */
    public String getEvaluatorusername() {
        return evaluatorusername;
    }

    /**
     * @param evaluatorusername
     */
    public void setEvaluatorusername(String evaluatorusername) {
        this.evaluatorusername = evaluatorusername;
    }

    /**
     * @return EVALUATORCORPID
     */
    public Long getEvaluatorcorpid() {
        return evaluatorcorpid;
    }

    /**
     * @param evaluatorcorpid
     */
    public void setEvaluatorcorpid(Long evaluatorcorpid) {
        this.evaluatorcorpid = evaluatorcorpid;
    }

    /**
     * @return EVALUATORCORPNAME
     */
    public String getEvaluatorcorpname() {
        return evaluatorcorpname;
    }

    /**
     * @param evaluatorcorpname
     */
    public void setEvaluatorcorpname(String evaluatorcorpname) {
        this.evaluatorcorpname = evaluatorcorpname;
    }

    /**
     * @return ASSESSSCORE
     */
    public double getAssessscore() {
        return assessscore;
    }

    /**
     * @param assessscore
     */
    public void setAssessscore(double assessscore) {
        this.assessscore = assessscore;
    }

    /**
     * @return ASSESSMULTIPLE
     */
    public Long getAssessmultiple() {
        return assessmultiple;
    }

    /**
     * @param assessmultiple
     */
    public void setAssessmultiple(Long assessmultiple) {
        this.assessmultiple = assessmultiple;
    }

    /**
     * @return ASSESSTOTAL
     */
    public double getAssesstotal() {
        return assesstotal;
    }

    /**
     * @param assesstotal
     */
    public void setAssesstotal(double assesstotal) {
        this.assesstotal = assesstotal;
    }

    /**
     * @return ASSESSDATE
     */
    public Date getAssessdate() {
        return assessdate;
    }

    /**
     * @param assessdate
     */
    public void setAssessdate(Date assessdate) {
        this.assessdate = assessdate;
    }

    /**
     * @return ASSESSCORPID
     */
    public Long getAssesscorpid() {
        return assesscorpid;
    }

    /**
     * @param assesscorpid
     */
    public void setAssesscorpid(Long assesscorpid) {
        this.assesscorpid = assesscorpid;
    }

    /**
     * @return ASSESSCORPNAME
     */
    public String getAssesscorpname() {
        return assesscorpname;
    }

    /**
     * @param assesscorpname
     */
    public void setAssesscorpname(String assesscorpname) {
        this.assesscorpname = assesscorpname;
    }

    /**
     * @return ASSESSUSERID
     */
    public Long getAssessuserid() {
        return assessuserid;
    }

    /**
     * @param assessuserid
     */
    public void setAssessuserid(Long assessuserid) {
        this.assessuserid = assessuserid;
    }

    /**
     * @return ASSESSUSERNAME
     */
    public String getAssessusername() {
        return assessusername;
    }

    /**
     * @param assessusername
     */
    public void setAssessusername(String assessusername) {
        this.assessusername = assessusername;
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
     * @return CHECKEDTYPE
     */
    public Long getCheckedtype() {
        return checkedtype;
    }

    /**
     * @param checkedtype
     */
    public void setCheckedtype(Long checkedtype) {
        this.checkedtype = checkedtype;
    }

    /**
     * @return CaseID
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
     * @return CaseAlarmID
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
}