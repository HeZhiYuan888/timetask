package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.BailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//取保候审提醒
@Component
public class BailAction {

    @Autowired
    private BailService bailService;

    @Scheduled(cron = "${alarmtask1}")
    public void insertToBail() {
        System.out.println(Thread.currentThread().getName()+"进入BailAction.insertToBail方法。"+new Date());
        for (int i = 1; i < 12; i++) {
            List<CaseInfo> lists = bailService.getBailByMonth(i);//一年内每月提醒
            bailService.insertByTurn(lists, 1, i);//index 为1，是按月
        }
        List<CaseInfo> before10Dayslists = new ArrayList<CaseInfo>();
        List<CaseInfo> before3Dayslists = new ArrayList<CaseInfo>();
        List<CaseInfo> before2Dayslists = new ArrayList<CaseInfo>();
        List<CaseInfo> before1Dayslists = new ArrayList<CaseInfo>();

        before10Dayslists = bailService.getBailByDay(10);//到期前十天
        before3Dayslists = bailService.getBailByDay(3);//前三天
        before2Dayslists = bailService.getBailByDay(2);//前两天
        before1Dayslists = bailService.getBailByDay(1);//前一天
        //插入数据
        bailService.insertByTurn(before10Dayslists, 2, 10);//index为2 是按天
        bailService.insertByTurn(before3Dayslists, 2, 3);
        bailService.insertByTurn(before2Dayslists, 2, 2);
        bailService.insertByTurn(before1Dayslists, 2, 1);

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(before10Dayslists);
            listAll.addAll(before3Dayslists);
            listAll.addAll(before2Dayslists);
            listAll.addAll(before1Dayslists);
            System.out.println("进入BailAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("进入BailAction结束");

    }



}
