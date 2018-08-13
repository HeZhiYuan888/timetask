package com.cetiti.hik.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CASEINFO")
public class CaseInfo {
    @Column(name = "ID")
    private Long id;

    @Column(name = "CASETYPEID")
    private String casetypeid;

    @Column(name = "CASETYPENAME")
    private String casetypename;

    @Column(name = "CASENAME")
    private String casename;

    @Column(name = "CASEATTRIBUTE")
    private String caseattribute;

    @Column(name = "CASESTATE")
    private String casestate;

    @Column(name = "CASESTATENAME")
    private String casestatename;

    @Column(name = "CASENUMBER")
    private String casenumber;

    @Column(name = "CASENATURE")
    private String casenature;

    @Column(name = "CASENATURENAME")
    private String casenaturename;

    @Column(name = "CASESOURCE")
    private String casesource;

    @Column(name = "CASESOURCENAME")
    private String casesourcename;

    @Column(name = "CORPID")
    private Long corpid;

    @Column(name = "CORPNAME")
    private String corpname;

    @Column(name = "ORGANISERID")
    private Long organiserid;

    @Column(name = "ORGANISERNAME")
    private String organisername;

    @Column(name = "COORGANISERID")
    private String coorganiserid;

    @Column(name = "COORGANISERNAME")
    private String coorganisername;

    @Column(name = "REVIEWMATURITYDATE")
    private Date reviewmaturitydate;

    @Column(name = "REVIEWDATE")
    private Date reviewdate;

    @Column(name = "DISCOVERYDATE")
    private Date discoverydate;

    @Column(name = "CASEUPPERDATE")
    private Date caseupperdate;

    @Column(name = "CASELOWERDATE")
    private Date caselowerdate;

    @Column(name = "RECEPTIONDATE")
    private Date receptiondate;

    @Column(name = "FILINGDATE")
    private Date filingdate;

    @Column(name = "TRANSFERDATE")
    private Date transferdate;

    @Column(name = "RECEIVINGDATE")
    private Date receivingdate;

    @Column(name = "DETECTIONAPPROVALDATE")
    private Date detectionapprovaldate;

    @Column(name = "ARCHIVINGDATE")
    private Date archivingdate;

    @Column(name = "REPORTBIRTHDAYDATE")
    private Date reportbirthdaydate;

    @Column(name = "REVOCATIONDATE")
    private Date revocationdate;

    @Column(name = "DETECTIONDATE")
    private Date detectiondate;

    @Column(name = "CLOSINGDATE")
    private Date closingdate;

    @Column(name = "CABINETNUM")
    private String cabinetnum;

    @Column(name = "DEVICEID")
    private Long deviceid;

    @Column(name = "CABINETCELL")
    private Long cabinetcell;

    @Column(name = "CELLNUMBER")
    private Long cellnumber;

    @Column(name = "BOXID")
    private Long boxid;

    @Column(name = "BOXNUM")
    private String boxnum;

    @Column(name = "BOXFLOORID")
    private Long boxfloorid;

    @Column(name = "BOXFLOORNUM")
    private String boxfloornum;

    @Column(name = "BOXEPC")
    private String boxepc;

    @Column(name = "BOXLOCATION")
    private Long boxlocation;

    @Column(name = "ISPASTEEPC")
    private Long ispasteepc;

    @Column(name = "ISCABINET")
    private Long iscabinet;

    @Column(name = "CABINETINOUTDATE")
    private Date cabinetinoutdate;

    @Column(name = "ISTURNONBOX")
    private Long isturnonbox;

    @Column(name = "ISBOX")
    private Long isbox;

    @Column(name = "TURNONINDATE")
    private Date turnonindate;

    @Column(name = "EPC")
    private String epc;

    @Column(name = "ISPROCURATORATE")
    private Long isprocuratorate;

    @Column(name = "ISBORROWED")
    private Long isborrowed;

    @Column(name = "BORROWEDDATE")
    private Date borroweddate;

    @Column(name = "RETURNDATE")
    private Date returndate;

    @Column(name = "STATE")
    private Long state;

    @Column(name = "NOWSTATE")
    private Long nowstate;

    @Column(name = "AJJBXXID")
    private Long ajjbxxid;

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

    @Column(name = "REPORTDATE")
    private Date reportdate;

    @Column(name = "CORPNUM")
    private String corpnum;

    @Column(name = "ORGANISERPOLICECODE")
    private String organiserpolicecode;

    @Column(name = "COORGANISERPOLICECODE")
    private String coorganiserpolicecode;

    @Column(name = "PROCURATORATEDATE")
    private Date procuratoratedate;

    @Column(name = "USERPOLICEID")
    private String userpoliceid;

    @Column(name = "LATEBB")
    private String latebb;

    @Column(name = "COORGANISERNUM")
    private String coorganisernum;

    @Column(name = "RELEGATIONCORPNAME")
    private String relegationcorpname;

    @Column(name = "RELEGATIONCORPID")
    private Long relegationcorpid;

    @Column(name = "RELEGATIONCORPNUM")
    private String relegationcorpnum;

    @Column(name = "ISCASEARCHIVES")
    private Long iscasearchives;

    @Column(name = "CASEARCHIVESDATE")
    private Date casearchivesdate;

    @Column(name = "CASEBRIEF")
    private String casebrief;

    private String dxmc;
    private Date jdsjdate;
    private Date rectificationTime;
    private Date finishTime;
    private long caseproblemid;

    public long getCaseproblemid() {
        return caseproblemid;
    }

    public void setCaseproblemid(long caseproblemid) {
        this.caseproblemid = caseproblemid;
    }

    public Date getJdsjdate() {
        return jdsjdate;
    }

    public void setJdsjdate(Date jdsjdate) {
        this.jdsjdate = jdsjdate;
    }

    public Date getRectificationTime() {
        return rectificationTime;
    }

    public void setRectificationTime(Date rectificationTime) {
        this.rectificationTime = rectificationTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getDxmc() {
        return dxmc;
    }

    public void setDxmc(String dxmc) {
        this.dxmc = dxmc;
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
     * @return CASETYPEID
     */
    public String getCasetypeid() {
        return casetypeid;
    }

    /**
     * @param casetypeid
     */
    public void setCasetypeid(String casetypeid) {
        this.casetypeid = casetypeid;
    }

    /**
     * @return CASETYPENAME
     */
    public String getCasetypename() {
        return casetypename;
    }

    /**
     * @param casetypename
     */
    public void setCasetypename(String casetypename) {
        this.casetypename = casetypename;
    }

    /**
     * @return CASENAME
     */
    public String getCasename() {
        return casename;
    }

    /**
     * @param casename
     */
    public void setCasename(String casename) {
        this.casename = casename;
    }

    /**
     * @return CASEATTRIBUTE
     */
    public String getCaseattribute() {
        return caseattribute;
    }

    /**
     * @param caseattribute
     */
    public void setCaseattribute(String caseattribute) {
        this.caseattribute = caseattribute;
    }

    /**
     * @return CASESTATE
     */
    public String getCasestate() {
        return casestate;
    }

    /**
     * @param casestate
     */
    public void setCasestate(String casestate) {
        this.casestate = casestate;
    }

    /**
     * @return CASESTATENAME
     */
    public String getCasestatename() {
        return casestatename;
    }

    /**
     * @param casestatename
     */
    public void setCasestatename(String casestatename) {
        this.casestatename = casestatename;
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
     * @return CASENATURE
     */
    public String getCasenature() {
        return casenature;
    }

    /**
     * @param casenature
     */
    public void setCasenature(String casenature) {
        this.casenature = casenature;
    }

    /**
     * @return CASENATURENAME
     */
    public String getCasenaturename() {
        return casenaturename;
    }

    /**
     * @param casenaturename
     */
    public void setCasenaturename(String casenaturename) {
        this.casenaturename = casenaturename;
    }

    /**
     * @return CASESOURCE
     */
    public String getCasesource() {
        return casesource;
    }

    /**
     * @param casesource
     */
    public void setCasesource(String casesource) {
        this.casesource = casesource;
    }

    /**
     * @return CASESOURCENAME
     */
    public String getCasesourcename() {
        return casesourcename;
    }

    /**
     * @param casesourcename
     */
    public void setCasesourcename(String casesourcename) {
        this.casesourcename = casesourcename;
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
     * @return ORGANISERID
     */
    public Long getOrganiserid() {
        return organiserid;
    }

    /**
     * @param organiserid
     */
    public void setOrganiserid(Long organiserid) {
        this.organiserid = organiserid;
    }

    /**
     * @return ORGANISERNAME
     */
    public String getOrganisername() {
        return organisername;
    }

    /**
     * @param organisername
     */
    public void setOrganisername(String organisername) {
        this.organisername = organisername;
    }

    /**
     * @return COORGANISERID
     */
    public String getCoorganiserid() {
        return coorganiserid;
    }

    /**
     * @param coorganiserid
     */
    public void setCoorganiserid(String coorganiserid) {
        this.coorganiserid = coorganiserid;
    }

    /**
     * @return COORGANISERNAME
     */
    public String getCoorganisername() {
        return coorganisername;
    }

    /**
     * @param coorganisername
     */
    public void setCoorganisername(String coorganisername) {
        this.coorganisername = coorganisername;
    }

    /**
     * @return REVIEWMATURITYDATE
     */
    public Date getReviewmaturitydate() {
        return reviewmaturitydate;
    }

    /**
     * @param reviewmaturitydate
     */
    public void setReviewmaturitydate(Date reviewmaturitydate) {
        this.reviewmaturitydate = reviewmaturitydate;
    }

    /**
     * @return REVIEWDATE
     */
    public Date getReviewdate() {
        return reviewdate;
    }

    /**
     * @param reviewdate
     */
    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }

    /**
     * @return DISCOVERYDATE
     */
    public Date getDiscoverydate() {
        return discoverydate;
    }

    /**
     * @param discoverydate
     */
    public void setDiscoverydate(Date discoverydate) {
        this.discoverydate = discoverydate;
    }

    /**
     * @return CASEUPPERDATE
     */
    public Date getCaseupperdate() {
        return caseupperdate;
    }

    /**
     * @param caseupperdate
     */
    public void setCaseupperdate(Date caseupperdate) {
        this.caseupperdate = caseupperdate;
    }

    /**
     * @return CASELOWERDATE
     */
    public Date getCaselowerdate() {
        return caselowerdate;
    }

    /**
     * @param caselowerdate
     */
    public void setCaselowerdate(Date caselowerdate) {
        this.caselowerdate = caselowerdate;
    }

    /**
     * @return RECEPTIONDATE
     */
    public Date getReceptiondate() {
        return receptiondate;
    }

    /**
     * @param receptiondate
     */
    public void setReceptiondate(Date receptiondate) {
        this.receptiondate = receptiondate;
    }

    /**
     * @return FILINGDATE
     */
    public Date getFilingdate() {
        return filingdate;
    }

    /**
     * @param filingdate
     */
    public void setFilingdate(Date filingdate) {
        this.filingdate = filingdate;
    }

    /**
     * @return TRANSFERDATE
     */
    public Date getTransferdate() {
        return transferdate;
    }

    /**
     * @param transferdate
     */
    public void setTransferdate(Date transferdate) {
        this.transferdate = transferdate;
    }

    /**
     * @return RECEIVINGDATE
     */
    public Date getReceivingdate() {
        return receivingdate;
    }

    /**
     * @param receivingdate
     */
    public void setReceivingdate(Date receivingdate) {
        this.receivingdate = receivingdate;
    }

    /**
     * @return DETECTIONAPPROVALDATE
     */
    public Date getDetectionapprovaldate() {
        return detectionapprovaldate;
    }

    /**
     * @param detectionapprovaldate
     */
    public void setDetectionapprovaldate(Date detectionapprovaldate) {
        this.detectionapprovaldate = detectionapprovaldate;
    }

    /**
     * @return ARCHIVINGDATE
     */
    public Date getArchivingdate() {
        return archivingdate;
    }

    /**
     * @param archivingdate
     */
    public void setArchivingdate(Date archivingdate) {
        this.archivingdate = archivingdate;
    }

    /**
     * @return REPORTBIRTHDAYDATE
     */
    public Date getReportbirthdaydate() {
        return reportbirthdaydate;
    }

    /**
     * @param reportbirthdaydate
     */
    public void setReportbirthdaydate(Date reportbirthdaydate) {
        this.reportbirthdaydate = reportbirthdaydate;
    }

    /**
     * @return REVOCATIONDATE
     */
    public Date getRevocationdate() {
        return revocationdate;
    }

    /**
     * @param revocationdate
     */
    public void setRevocationdate(Date revocationdate) {
        this.revocationdate = revocationdate;
    }

    /**
     * @return DETECTIONDATE
     */
    public Date getDetectiondate() {
        return detectiondate;
    }

    /**
     * @param detectiondate
     */
    public void setDetectiondate(Date detectiondate) {
        this.detectiondate = detectiondate;
    }

    /**
     * @return CLOSINGDATE
     */
    public Date getClosingdate() {
        return closingdate;
    }

    /**
     * @param closingdate
     */
    public void setClosingdate(Date closingdate) {
        this.closingdate = closingdate;
    }

    /**
     * @return CABINETNUM
     */
    public String getCabinetnum() {
        return cabinetnum;
    }

    /**
     * @param cabinetnum
     */
    public void setCabinetnum(String cabinetnum) {
        this.cabinetnum = cabinetnum;
    }

    /**
     * @return DEVICEID
     */
    public Long getDeviceid() {
        return deviceid;
    }

    /**
     * @param deviceid
     */
    public void setDeviceid(Long deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * @return CABINETCELL
     */
    public Long getCabinetcell() {
        return cabinetcell;
    }

    /**
     * @param cabinetcell
     */
    public void setCabinetcell(Long cabinetcell) {
        this.cabinetcell = cabinetcell;
    }

    /**
     * @return CELLNUMBER
     */
    public Long getCellnumber() {
        return cellnumber;
    }

    /**
     * @param cellnumber
     */
    public void setCellnumber(Long cellnumber) {
        this.cellnumber = cellnumber;
    }

    /**
     * @return BOXID
     */
    public Long getBoxid() {
        return boxid;
    }

    /**
     * @param boxid
     */
    public void setBoxid(Long boxid) {
        this.boxid = boxid;
    }

    /**
     * @return BOXNUM
     */
    public String getBoxnum() {
        return boxnum;
    }

    /**
     * @param boxnum
     */
    public void setBoxnum(String boxnum) {
        this.boxnum = boxnum;
    }

    /**
     * @return BOXFLOORID
     */
    public Long getBoxfloorid() {
        return boxfloorid;
    }

    /**
     * @param boxfloorid
     */
    public void setBoxfloorid(Long boxfloorid) {
        this.boxfloorid = boxfloorid;
    }

    /**
     * @return BOXFLOORNUM
     */
    public String getBoxfloornum() {
        return boxfloornum;
    }

    /**
     * @param boxfloornum
     */
    public void setBoxfloornum(String boxfloornum) {
        this.boxfloornum = boxfloornum;
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
     * @return ISPASTEEPC
     */
    public Long getIspasteepc() {
        return ispasteepc;
    }

    /**
     * @param ispasteepc
     */
    public void setIspasteepc(Long ispasteepc) {
        this.ispasteepc = ispasteepc;
    }

    /**
     * @return ISCABINET
     */
    public Long getIscabinet() {
        return iscabinet;
    }

    /**
     * @param iscabinet
     */
    public void setIscabinet(Long iscabinet) {
        this.iscabinet = iscabinet;
    }

    /**
     * @return CABINETINOUTDATE
     */
    public Date getCabinetinoutdate() {
        return cabinetinoutdate;
    }

    /**
     * @param cabinetinoutdate
     */
    public void setCabinetinoutdate(Date cabinetinoutdate) {
        this.cabinetinoutdate = cabinetinoutdate;
    }

    /**
     * @return ISTURNONBOX
     */
    public Long getIsturnonbox() {
        return isturnonbox;
    }

    /**
     * @param isturnonbox
     */
    public void setIsturnonbox(Long isturnonbox) {
        this.isturnonbox = isturnonbox;
    }

    /**
     * @return ISBOX
     */
    public Long getIsbox() {
        return isbox;
    }

    /**
     * @param isbox
     */
    public void setIsbox(Long isbox) {
        this.isbox = isbox;
    }

    /**
     * @return TURNONINDATE
     */
    public Date getTurnonindate() {
        return turnonindate;
    }

    /**
     * @param turnonindate
     */
    public void setTurnonindate(Date turnonindate) {
        this.turnonindate = turnonindate;
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
     * @return ISPROCURATORATE
     */
    public Long getIsprocuratorate() {
        return isprocuratorate;
    }

    /**
     * @param isprocuratorate
     */
    public void setIsprocuratorate(Long isprocuratorate) {
        this.isprocuratorate = isprocuratorate;
    }

    /**
     * @return ISBORROWED
     */
    public Long getIsborrowed() {
        return isborrowed;
    }

    /**
     * @param isborrowed
     */
    public void setIsborrowed(Long isborrowed) {
        this.isborrowed = isborrowed;
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
     * @return NOWSTATE
     */
    public Long getNowstate() {
        return nowstate;
    }

    /**
     * @param nowstate
     */
    public void setNowstate(Long nowstate) {
        this.nowstate = nowstate;
    }

    /**
     * @return AJJBXXID
     */
    public Long getAjjbxxid() {
        return ajjbxxid;
    }

    /**
     * @param ajjbxxid
     */
    public void setAjjbxxid(Long ajjbxxid) {
        this.ajjbxxid = ajjbxxid;
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
     * @return REPORTDATE
     */
    public Date getReportdate() {
        return reportdate;
    }

    /**
     * @param reportdate
     */
    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    /**
     * @return CORPNUM
     */
    public String getCorpnum() {
        return corpnum;
    }

    /**
     * @param corpnum
     */
    public void setCorpnum(String corpnum) {
        this.corpnum = corpnum;
    }

    /**
     * @return ORGANISERPOLICECODE
     */
    public String getOrganiserpolicecode() {
        return organiserpolicecode;
    }

    /**
     * @param organiserpolicecode
     */
    public void setOrganiserpolicecode(String organiserpolicecode) {
        this.organiserpolicecode = organiserpolicecode;
    }

    /**
     * @return COORGANISERPOLICECODE
     */
    public String getCoorganiserpolicecode() {
        return coorganiserpolicecode;
    }

    /**
     * @param coorganiserpolicecode
     */
    public void setCoorganiserpolicecode(String coorganiserpolicecode) {
        this.coorganiserpolicecode = coorganiserpolicecode;
    }

    /**
     * @return PROCURATORATEDATE
     */
    public Date getProcuratoratedate() {
        return procuratoratedate;
    }

    /**
     * @param procuratoratedate
     */
    public void setProcuratoratedate(Date procuratoratedate) {
        this.procuratoratedate = procuratoratedate;
    }

    /**
     * @return USERPOLICEID
     */
    public String getUserpoliceid() {
        return userpoliceid;
    }

    /**
     * @param userpoliceid
     */
    public void setUserpoliceid(String userpoliceid) {
        this.userpoliceid = userpoliceid;
    }

    /**
     * @return LATEBB
     */
    public String getLatebb() {
        return latebb;
    }

    /**
     * @param latebb
     */
    public void setLatebb(String latebb) {
        this.latebb = latebb;
    }

    /**
     * @return COORGANISERNUM
     */
    public String getCoorganisernum() {
        return coorganisernum;
    }

    /**
     * @param coorganisernum
     */
    public void setCoorganisernum(String coorganisernum) {
        this.coorganisernum = coorganisernum;
    }

    /**
     * @return RELEGATIONCORPNAME
     */
    public String getRelegationcorpname() {
        return relegationcorpname;
    }

    /**
     * @param relegationcorpname
     */
    public void setRelegationcorpname(String relegationcorpname) {
        this.relegationcorpname = relegationcorpname;
    }

    /**
     * @return RELEGATIONCORPID
     */
    public Long getRelegationcorpid() {
        return relegationcorpid;
    }

    /**
     * @param relegationcorpid
     */
    public void setRelegationcorpid(Long relegationcorpid) {
        this.relegationcorpid = relegationcorpid;
    }

    /**
     * @return RELEGATIONCORPNUM
     */
    public String getRelegationcorpnum() {
        return relegationcorpnum;
    }

    /**
     * @param relegationcorpnum
     */
    public void setRelegationcorpnum(String relegationcorpnum) {
        this.relegationcorpnum = relegationcorpnum;
    }

    /**
     * @return ISCASEARCHIVES
     */
    public Long getIscasearchives() {
        return iscasearchives;
    }

    /**
     * @param iscasearchives
     */
    public void setIscasearchives(Long iscasearchives) {
        this.iscasearchives = iscasearchives;
    }

    /**
     * @return CASEARCHIVESDATE
     */
    public Date getCasearchivesdate() {
        return casearchivesdate;
    }

    /**
     * @param casearchivesdate
     */
    public void setCasearchivesdate(Date casearchivesdate) {
        this.casearchivesdate = casearchivesdate;
    }

    /**
     * @return CASEBRIEF
     */
    public String getCasebrief() {
        return casebrief;
    }

    /**
     * @param casebrief
     */
    public void setCasebrief(String casebrief) {
        this.casebrief = casebrief;
    }
}