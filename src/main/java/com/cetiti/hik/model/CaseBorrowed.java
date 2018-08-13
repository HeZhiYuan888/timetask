package com.cetiti.hik.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CASEBORROWED")
public class CaseBorrowed {
    @Column(name = "ID")
    private Long id;

    @Column(name = "CASEID")
    private Long caseid;

    @Column(name = "CASENUMBER")
    private String casenumber;

    @Column(name = "BORROWEDDATE")
    private Date borroweddate;

    @Column(name = "BORROWEDCORPID")
    private Long borrowedcorpid;

    @Column(name = "BORROWEDCORPNAME")
    private String borrowedcorpname;

    @Column(name = "BORROWEDUSERID")
    private Long borroweduserid;

    @Column(name = "BORROWEDUSERNAME")
    private String borrowedusername;

    @Column(name = "BORROWEDSTATE")
    private Long borrowedstate;

    @Column(name = "RETURNDATE")
    private Date returndate;

    @Column(name = "RETURNCORPID")
    private Long returncorpid;

    @Column(name = "RETURNCORPNAME")
    private String returncorpname;

    @Column(name = "RETURNUSERID")
    private Long returnuserid;

    @Column(name = "RETURNUSERNAME")
    private String returnusername;

    @Column(name = "RETURNCONFIRMDATE")
    private Date returnconfirmdate;

    @Column(name = "RETURNCONFIRMCORPID")
    private Long returnconfirmcorpid;

    @Column(name = "RETURNCONFIRMCORPNAME")
    private String returnconfirmcorpname;

    @Column(name = "RETURNCONFIRMUSERID")
    private Long returnconfirmuserid;

    @Column(name = "RETURNCONFIRMUSERNAME")
    private String returnconfirmusername;

    @Column(name = "EPC")
    private String epc;

    @Column(name = "BOXEPC")
    private String boxepc;

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
     * @return BORROWEDDATE
     */
    public Date getBorroweddate() {
        return borroweddate;
    }

    /**
     * @param borroweddate
     */
    public void setBorroweddate(Date borroweddate) {
        this.borroweddate = borroweddate;
    }

    /**
     * @return BORROWEDCORPID
     */
    public Long getBorrowedcorpid() {
        return borrowedcorpid;
    }

    /**
     * @param borrowedcorpid
     */
    public void setBorrowedcorpid(Long borrowedcorpid) {
        this.borrowedcorpid = borrowedcorpid;
    }

    /**
     * @return BORROWEDCORPNAME
     */
    public String getBorrowedcorpname() {
        return borrowedcorpname;
    }

    /**
     * @param borrowedcorpname
     */
    public void setBorrowedcorpname(String borrowedcorpname) {
        this.borrowedcorpname = borrowedcorpname;
    }

    /**
     * @return BORROWEDUSERID
     */
    public Long getBorroweduserid() {
        return borroweduserid;
    }

    /**
     * @param borroweduserid
     */
    public void setBorroweduserid(Long borroweduserid) {
        this.borroweduserid = borroweduserid;
    }

    /**
     * @return BORROWEDUSERNAME
     */
    public String getBorrowedusername() {
        return borrowedusername;
    }

    /**
     * @param borrowedusername
     */
    public void setBorrowedusername(String borrowedusername) {
        this.borrowedusername = borrowedusername;
    }

    /**
     * @return BORROWEDSTATE
     */
    public Long getBorrowedstate() {
        return borrowedstate;
    }

    /**
     * @param borrowedstate
     */
    public void setBorrowedstate(Long borrowedstate) {
        this.borrowedstate = borrowedstate;
    }

    /**
     * @return RETURNDATE
     */
    public Date getReturndate() {
        return returndate;
    }

    /**
     * @param returndate
     */
    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    /**
     * @return RETURNCORPID
     */
    public Long getReturncorpid() {
        return returncorpid;
    }

    /**
     * @param returncorpid
     */
    public void setReturncorpid(Long returncorpid) {
        this.returncorpid = returncorpid;
    }

    /**
     * @return RETURNCORPNAME
     */
    public String getReturncorpname() {
        return returncorpname;
    }

    /**
     * @param returncorpname
     */
    public void setReturncorpname(String returncorpname) {
        this.returncorpname = returncorpname;
    }

    /**
     * @return RETURNUSERID
     */
    public Long getReturnuserid() {
        return returnuserid;
    }

    /**
     * @param returnuserid
     */
    public void setReturnuserid(Long returnuserid) {
        this.returnuserid = returnuserid;
    }

    /**
     * @return RETURNUSERNAME
     */
    public String getReturnusername() {
        return returnusername;
    }

    /**
     * @param returnusername
     */
    public void setReturnusername(String returnusername) {
        this.returnusername = returnusername;
    }

    /**
     * @return RETURNCONFIRMDATE
     */
    public Date getReturnconfirmdate() {
        return returnconfirmdate;
    }

    /**
     * @param returnconfirmdate
     */
    public void setReturnconfirmdate(Date returnconfirmdate) {
        this.returnconfirmdate = returnconfirmdate;
    }

    /**
     * @return RETURNCONFIRMCORPID
     */
    public Long getReturnconfirmcorpid() {
        return returnconfirmcorpid;
    }

    /**
     * @param returnconfirmcorpid
     */
    public void setReturnconfirmcorpid(Long returnconfirmcorpid) {
        this.returnconfirmcorpid = returnconfirmcorpid;
    }

    /**
     * @return RETURNCONFIRMCORPNAME
     */
    public String getReturnconfirmcorpname() {
        return returnconfirmcorpname;
    }

    /**
     * @param returnconfirmcorpname
     */
    public void setReturnconfirmcorpname(String returnconfirmcorpname) {
        this.returnconfirmcorpname = returnconfirmcorpname;
    }

    /**
     * @return RETURNCONFIRMUSERID
     */
    public Long getReturnconfirmuserid() {
        return returnconfirmuserid;
    }

    /**
     * @param returnconfirmuserid
     */
    public void setReturnconfirmuserid(Long returnconfirmuserid) {
        this.returnconfirmuserid = returnconfirmuserid;
    }

    /**
     * @return RETURNCONFIRMUSERNAME
     */
    public String getReturnconfirmusername() {
        return returnconfirmusername;
    }

    /**
     * @param returnconfirmusername
     */
    public void setReturnconfirmusername(String returnconfirmusername) {
        this.returnconfirmusername = returnconfirmusername;
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