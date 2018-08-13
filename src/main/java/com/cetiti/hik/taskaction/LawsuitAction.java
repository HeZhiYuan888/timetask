package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.LawsuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//案件移诉提醒
@Component
public class LawsuitAction {
    @Autowired
    private LawsuitService lawsuitService;
    @Scheduled(cron = "${alarmtask6}")
    public void insertToLawsuit() {
        System.out.println(Thread.currentThread().getName()+"进入LawsuitAction方法。"+new Date());
        List<CaseInfo> lists  = new ArrayList<CaseInfo>();
        List<CaseInfo> lists3  = new ArrayList<CaseInfo>();
        List<CaseInfo> lists2  = new ArrayList<CaseInfo>();
        List<CaseInfo> lists1  = new ArrayList<CaseInfo>();

        lists = lawsuitService.getLawsuitByMonth(1);//满月提醒
        lawsuitService.insertByTurn(lists, 1, 1);//index 为1，是按月

        lists3 = lawsuitService.getLawsuitByDay(3);
        lists2 = lawsuitService.getLawsuitByDay(2);
        lists1 = lawsuitService.getLawsuitByDay(1);
        lawsuitService.insertByTurn(lists3, 2, 3);//前三天
        lawsuitService.insertByTurn(lists2, 2, 2);//前两天
        lawsuitService.insertByTurn(lists1, 2, 1);//前一天

        try {
            List listAll = new ArrayList();
            listAll.addAll(lists);
            listAll.addAll(lists3);
            listAll.addAll(lists2);
            listAll.addAll(lists1);
            System.out.println("LawsuitAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("LawsuitAction结束");

    }


}
