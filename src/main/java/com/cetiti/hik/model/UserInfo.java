package com.cetiti.hik.model;

import java.awt.image.TileObserver;
import java.util.Date;
import javax.persistence.*;

@Table(name = "USERINFO")
public class UserInfo {
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USERTYPE")
    private Long usertype;

    @Column(name = "CORPID")
    private Long corpid;

    @Column(name = "GENDER")
    private Long gender;

    @Column(name = "MOBILEPHONE")
    private String mobilephone;

    @Column(name = "PRIVILEGETYPE")
    private Long privilegetype;

    @Column(name = "PRIVILEGEVALUE")
    private String privilegevalue;

    @Column(name = "OPERATEPRIVILEGETYPE")
    private Long operateprivilegetype;

    @Column(name = "OPERATEPRIVILEGEVALUE")
    private String operateprivilegevalue;

    @Column(name = "LASTLOGINTIME")
    private Date lastlogintime;

    @Column(name = "LASTLOGINIP")
    private String lastloginip;

    @Column(name = "STATE")
    private Long state;

    @Column(name = "SEQUENCE")
    private Long sequence;

    @Column(name = "IMBQUALITY")
    private Long imbquality;

    @Column(name = "ISADDCUPBOARD")
    private Long isaddcupboard;

    @Column(name = "CUPBOARDNUMBER")
    private String cupboardnumber;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PKISUBJECTNAME")
    private String pkisubjectname;

    @Column(name = "DEVICEID")
    private String deviceid;

    @Column(name = "POLICECODE")
    private String policecode;

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

    @Column(name = "CORPDEVICEID")
    private Long corpdeviceid;

    @Column(name = "CORPDEVICECODE")
    private String corpdevicecode;

    @Column(name = "USERPOLICEID")
    private String userpoliceid;

    @Column(name = "CUPBOARDNUMBERNAME")
    private String cupboardnumbername;

    @Column(name = "DEVICECUPBOARDNAME")
    private String devicecupboardname;

    @Column(name = "USERPOLICEIDS")
    private String userpoliceids;

    @Column(name = "FINGERPRINTINFO")
    private String fingerprintinfo;

    @Column(name = "ISFINGERPRINT")
    private Long isfingerprint;

    @Column(name = "YHZWXX")
    private String yhzwxx;

    @Column(name = "ISZWDJ")
    private Long iszwdj;

    @Column(name = "SYSTEMCODE")
    private String systemcode;

    @Column(name = "CPMBBUF")
    private byte[] cpmbbuf;

    @Column(name = "YHZWXXBT")
    private byte[] yhzwxxbt;

    public UserInfo(){
    }

    public UserInfo(long corpid,long usertype){
        this.corpid = corpid;
        this.usertype = usertype;
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
     * @return ACCOUNT
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return USERTYPE
     */
    public Long getUsertype() {
        return usertype;
    }

    /**
     * @param usertype
     */
    public void setUsertype(Long usertype) {
        this.usertype = usertype;
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
     * @return GENDER
     */
    public Long getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(Long gender) {
        this.gender = gender;
    }

    /**
     * @return MOBILEPHONE
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * @param mobilephone
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * @return PRIVILEGETYPE
     */
    public Long getPrivilegetype() {
        return privilegetype;
    }

    /**
     * @param privilegetype
     */
    public void setPrivilegetype(Long privilegetype) {
        this.privilegetype = privilegetype;
    }

    /**
     * @return PRIVILEGEVALUE
     */
    public String getPrivilegevalue() {
        return privilegevalue;
    }

    /**
     * @param privilegevalue
     */
    public void setPrivilegevalue(String privilegevalue) {
        this.privilegevalue = privilegevalue;
    }

    /**
     * @return OPERATEPRIVILEGETYPE
     */
    public Long getOperateprivilegetype() {
        return operateprivilegetype;
    }

    /**
     * @param operateprivilegetype
     */
    public void setOperateprivilegetype(Long operateprivilegetype) {
        this.operateprivilegetype = operateprivilegetype;
    }

    /**
     * @return OPERATEPRIVILEGEVALUE
     */
    public String getOperateprivilegevalue() {
        return operateprivilegevalue;
    }

    /**
     * @param operateprivilegevalue
     */
    public void setOperateprivilegevalue(String operateprivilegevalue) {
        this.operateprivilegevalue = operateprivilegevalue;
    }

    /**
     * @return LASTLOGINTIME
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * @param lastlogintime
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * @return LASTLOGINIP
     */
    public String getLastloginip() {
        return lastloginip;
    }

    /**
     * @param lastloginip
     */
    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
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
     * @return SEQUENCE
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * @param sequence
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    /**
     * @return IMBQUALITY
     */
    public Long getImbquality() {
        return imbquality;
    }

    /**
     * @param imbquality
     */
    public void setImbquality(Long imbquality) {
        this.imbquality = imbquality;
    }

    /**
     * @return ISADDCUPBOARD
     */
    public Long getIsaddcupboard() {
        return isaddcupboard;
    }

    /**
     * @param isaddcupboard
     */
    public void setIsaddcupboard(Long isaddcupboard) {
        this.isaddcupboard = isaddcupboard;
    }

    /**
     * @return CUPBOARDNUMBER
     */
    public String getCupboardnumber() {
        return cupboardnumber;
    }

    /**
     * @param cupboardnumber
     */
    public void setCupboardnumber(String cupboardnumber) {
        this.cupboardnumber = cupboardnumber;
    }

    /**
     * @return COMPANY
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return PKISUBJECTNAME
     */
    public String getPkisubjectname() {
        return pkisubjectname;
    }

    /**
     * @param pkisubjectname
     */
    public void setPkisubjectname(String pkisubjectname) {
        this.pkisubjectname = pkisubjectname;
    }

    /**
     * @return DEVICEID
     */
    public String getDeviceid() {
        return deviceid;
    }

    /**
     * @param deviceid
     */
    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * @return POLICECODE
     */
    public String getPolicecode() {
        return policecode;
    }

    /**
     * @param policecode
     */
    public void setPolicecode(String policecode) {
        this.policecode = policecode;
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
     * @return CORPDEVICEID
     */
    public Long getCorpdeviceid() {
        return corpdeviceid;
    }

    /**
     * @param corpdeviceid
     */
    public void setCorpdeviceid(Long corpdeviceid) {
        this.corpdeviceid = corpdeviceid;
    }

    /**
     * @return CORPDEVICECODE
     */
    public String getCorpdevicecode() {
        return corpdevicecode;
    }

    /**
     * @param corpdevicecode
     */
    public void setCorpdevicecode(String corpdevicecode) {
        this.corpdevicecode = corpdevicecode;
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
     * @return CUPBOARDNUMBERNAME
     */
    public String getCupboardnumbername() {
        return cupboardnumbername;
    }

    /**
     * @param cupboardnumbername
     */
    public void setCupboardnumbername(String cupboardnumbername) {
        this.cupboardnumbername = cupboardnumbername;
    }

    /**
     * @return DEVICECUPBOARDNAME
     */
    public String getDevicecupboardname() {
        return devicecupboardname;
    }

    /**
     * @param devicecupboardname
     */
    public void setDevicecupboardname(String devicecupboardname) {
        this.devicecupboardname = devicecupboardname;
    }

    /**
     * @return USERPOLICEIDS
     */
    public String getUserpoliceids() {
        return userpoliceids;
    }

    /**
     * @param userpoliceids
     */
    public void setUserpoliceids(String userpoliceids) {
        this.userpoliceids = userpoliceids;
    }

    /**
     * @return FINGERPRINTINFO
     */
    public String getFingerprintinfo() {
        return fingerprintinfo;
    }

    /**
     * @param fingerprintinfo
     */
    public void setFingerprintinfo(String fingerprintinfo) {
        this.fingerprintinfo = fingerprintinfo;
    }

    /**
     * @return ISFINGERPRINT
     */
    public Long getIsfingerprint() {
        return isfingerprint;
    }

    /**
     * @param isfingerprint
     */
    public void setIsfingerprint(Long isfingerprint) {
        this.isfingerprint = isfingerprint;
    }

    /**
     * @return YHZWXX
     */
    public String getYhzwxx() {
        return yhzwxx;
    }

    /**
     * @param yhzwxx
     */
    public void setYhzwxx(String yhzwxx) {
        this.yhzwxx = yhzwxx;
    }

    /**
     * @return ISZWDJ
     */
    public Long getIszwdj() {
        return iszwdj;
    }

    /**
     * @param iszwdj
     */
    public void setIszwdj(Long iszwdj) {
        this.iszwdj = iszwdj;
    }

    /**
     * @return SYSTEMCODE
     */
    public String getSystemcode() {
        return systemcode;
    }

    /**
     * @param systemcode
     */
    public void setSystemcode(String systemcode) {
        this.systemcode = systemcode;
    }

    /**
     * @return CPMBBUF
     */
    public byte[] getCpmbbuf() {
        return cpmbbuf;
    }

    /**
     * @param cpmbbuf
     */
    public void setCpmbbuf(byte[] cpmbbuf) {
        this.cpmbbuf = cpmbbuf;
    }

    /**
     * @return YHZWXXBT
     */
    public byte[] getYhzwxxbt() {
        return yhzwxxbt;
    }

    /**
     * @param yhzwxxbt
     */
    public void setYhzwxxbt(byte[] yhzwxxbt) {
        this.yhzwxxbt = yhzwxxbt;
    }
}