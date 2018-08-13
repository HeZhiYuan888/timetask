package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.DetentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//拘留到期提醒
@Component
public class DetentionAction {
    @Autowired
    private DetentionService detentionService;
    @Scheduled(cron = "${alarmtask5}")
    public void insertToDetention() {
        System.out.println(Thread.currentThread().getName()+"进入DetentionAction方法。"+new Date());
        List<CaseInfo> lists7  = new ArrayList<CaseInfo>();
        List<CaseInfo> lists20  = new ArrayList<CaseInfo>();
        List<CaseInfo> lists28  = new ArrayList<CaseInfo>();
        List<CaseInfo> lists29  = new ArrayList<CaseInfo>();
        List<CaseInfo> lists30  = new ArrayList<CaseInfo>();

        lists7 = detentionService.detention7Days();
        lists20 = detentionService.detention30Days(20,true);
        lists28 = detentionService.detention30Days(28,true);
        lists29 = detentionService.detention30Days(29,true);
        lists30 = detentionService.detention30Days(30,true);

        detentionService.insertByTurn(lists7, 1, 0);//拘留到期第一项，自刑拘起7天提醒一次
        detentionService.insertByTurn(lists20, 2, 20);//拘留到期第二项，自刑拘起20天提醒一次
        detentionService.insertByTurn(lists28, 2, 28);//拘留到期第二项，自刑拘起28天提醒一次
        detentionService.insertByTurn(lists29, 2, 29);//拘留到期第二项，自刑拘起29天提醒一次
        detentionService.insertByTurn(lists30, 2, 30);//拘留到期第二项，自刑拘起30天提醒一次

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(lists7);
            listAll.addAll(lists20);
            listAll.addAll(lists28);
            listAll.addAll(lists29);
            listAll.addAll(lists30);
            System.out.println("DetentionAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("DetentionAction结束");
    }
    @Scheduled(cron = "${alarmtask12}")
    public void insertToAfternoon()
    {
        List<CaseInfo> lists  = new ArrayList<CaseInfo>();
        lists = detentionService.detention7DayAfternoon();
        detentionService.insertByTurn(lists, 1, 0);
    }

}
