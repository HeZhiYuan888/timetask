package com.cetiti.hik.paramVO;


import java.util.Date;

public class CaseBorrowedParam {

    private Date borrowedDate;

    private int borrowedState;

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
}
