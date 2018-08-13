package com.cetiti.hik.paramVO;


import java.util.Date;

public class UserInfoParam {

    private Date borrowedDate;

    private int borrowedState;

    private long corpid;

    private int usertype;

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public int getBorrowedState() {
        return borrowedState;
    }

    public void setBorrowedState(int borrowedState) {
        this.borrowedState = borrowedState;
    }

    public long getCorpid() {
        return corpid;
    }

    public void setCorpid(long corpid) {
        this.corpid = corpid;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
}