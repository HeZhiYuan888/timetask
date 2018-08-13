package com.cetiti.hik.taskaction;


import com.cetiti.hik.taskservice.CaseBorrowedService;
import com.cetiti.hik.model.CaseBorrowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 借阅超期提醒，超期一天、超期三天
 */
@Component
public class CaseBorrowedAction {
    @Autowired
    CaseBorrowedService caseBorrowedService;

    @Scheduled(cron = "${alarmtask3}")
    public void insertCaseBorrowed() {
        System.out.println(Thread.currentThread().getName()+"进入CaseBorrowedAction方法。"+new Date());
        List<CaseBorrowed> oneDayLists = new ArrayList<CaseBorrowed>();
        List<CaseBorrowed> threeDayLists = new ArrayList<CaseBorrowed>();

        oneDayLists = caseBorrowedService.getCaseBorrowOverOneDay();
        threeDayLists = caseBorrowedService.getCaseBorrowOverThreeDay();

        caseBorrowedService.insertByTurn(oneDayLists, true);
        caseBorrowedService.insertByTurn(threeDayLists, false);

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(oneDayLists);
            listAll.addAll(threeDayLists);
            System.out.println("CaseBorrowedAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("CaseBorrowedAction结束");
    }

}
