package com.cetiti.hik.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CASEFLOWRECORD")
public class CaseFlowRecord {
    @Column(name = "ID")
    private Long id;

    @Column(name = "CASEID")
    private Long caseid;

    @Column(name = "CASENUMBER")
    private String casenumber;

    @Column(name = "DEVICECODE")
    private String devicecode;

    @Column(name = "EPC")
    private String epc;

    @Column(name = "BOXEPC")
    private String boxepc;

    @Column(name = "BOXLOCATION")
    private Long boxlocation;

    @Column(name = "FLOWUSERID")
    private Long flowuserid;

    @Column(name = "FLOWUSERNAME")
    private String flowusername;

    @Column(name = "FLOWCORPID")
    private Long flowcorpid;

    @Column(name = "FLOWCORPNAME")
    private String flowcorpname;

    @Column(name = "FLOWDATE")
    private Date flowdate;

    @Column(name = "FLOWSTART")
    private Long flowstart;

    @Column(name = "FLOWCONTER")
    private String flowconter;

    @Column(name = "STATE")
    private Long state;

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
     * @return DEVICECODE
     */
    public String getDevicecode() {
        return devicecode;
    }

    /**
     * @param devicecode
     */
    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
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
     * @return BOXEPC
     */
    public String getBoxepc() {
        return boxepc;
    }

    /**
     * @param boxepc
     */
    public void setBoxepc(String boxepc) {
        this.boxepc = boxepc;
    }

    /**
     * @return BOXLOCATION
     */
    public Long getBoxlocation() {
        return boxlocation;
    }

    /**
     * @param boxlocation
     */
    public void setBoxlocation(Long boxlocation) {
        this.boxlocation = boxlocation;
    }

    /**
     * @return FLOWUSERID
     */
    public Long getFlowuserid() {
        return flowuserid;
    }

    /**
     * @param flowuserid
     */
    public void setFlowuserid(Long flowuserid) {
        this.flowuserid = flowuserid;
    }

    /**
     * @return FLOWUSERNAME
     */
    public String getFlowusername() {
        return flowusername;
    }

    /**
     * @param flowusername
     */
    public void setFlowusername(String flowusername) {
        this.flowusername = flowusername;
    }

    /**
     * @return FLOWCORPID
     */
    public Long getFlowcorpid() {
        return flowcorpid;
    }

    /**
     * @param flowcorpid
     */
    public void setFlowcorpid(Long flowcorpid) {
        this.flowcorpid = flowcorpid;
    }

    /**
     * @return FLOWCORPNAME
     */
    public String getFlowcorpname() {
        return flowcorpname;
    }

    /**
     * @param flowcorpname
     */
    public void setFlowcorpname(String flowcorpname) {
        this.flowcorpname = flowcorpname;
    }

    /**
     * @return FLOWDATE
     */
    public Date getFlowdate() {
        return flowdate;
    }

    /**
     * @param flowdate
     */
    public void setFlowdate(Date flowdate) {
        this.flowdate = flowdate;
    }

    /**
     * @return FLOWSTART
     */
    public Long getFlowstart() {
        return flowstart;
    }

    /**
     * @param flowstart
     */
    public void setFlowstart(Long flowstart) {
        this.flowstart = flowstart;
    }

    /**
     * @return FLOWCONTER
     */
    public String getFlowconter() {
        return flowconter;
    }

    /**
     * @param flowconter
     */
    public void setFlowconter(String flowconter) {
        this.flowconter = flowconter;
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
}