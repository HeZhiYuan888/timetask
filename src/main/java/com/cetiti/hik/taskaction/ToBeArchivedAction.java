package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.ToBeArchivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//待归档提醒
@Component
public class ToBeArchivedAction {

    @Autowired
    private ToBeArchivedService toBeArchivedService;
    @Scheduled(cron = "${alarmtask11}")
    public void insertToBeArchived() {
        System.out.println(Thread.currentThread().getName()+"进入ToBeArchivedAction方法。"+new Date());
        List<CaseInfo> fullYearLists = new ArrayList<CaseInfo>();
        List<CaseInfo> sevenDayLLsts = new ArrayList<CaseInfo>();
        List<CaseInfo> sixMonthLists = new ArrayList<CaseInfo>();
        List<CaseInfo> twelveMonthLists = new ArrayList<CaseInfo>();

        fullYearLists = toBeArchivedService.getTobeArchivedFullYear();
        sevenDayLLsts = toBeArchivedService.getTobeArchivedProsecution();
        sixMonthLists = toBeArchivedService.getTobeArchivedNoMove6Month();
        twelveMonthLists = toBeArchivedService.getTobeArchivedNoMove12Month();

        toBeArchivedService.insertByTurn(fullYearLists, 1);//自结案起一年
        toBeArchivedService.insertByTurn(sevenDayLLsts, 2);//自移送起诉起7日
        toBeArchivedService.insertByTurn(sixMonthLists, 3);//自立案起6个月
        toBeArchivedService.insertByTurn(twelveMonthLists, 4);//自立案起一年

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(fullYearLists);
            listAll.addAll(sevenDayLLsts);
            listAll.addAll(sixMonthLists);
            listAll.addAll(twelveMonthLists);
            System.out.println("ToBeArchivedAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("ToBeArchivedAction结束");

    }

}
