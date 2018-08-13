package com.cetiti.hik.taskaction;


import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.NoTagOver24HourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class NoTagOver24HourAction {

    @Autowired
    private NoTagOver24HourService noTagOver24HourService;
    @Scheduled(cron = "${alarmtask8}")
    public void insertNoTagOver24Hour() {
        System.out.println(Thread.currentThread().getName()+"进入NoTagOver24HourAction方法。"+new Date());
        List<CaseInfo> lists = new ArrayList<CaseInfo>();
        lists = noTagOver24HourService.getNoTagOver24Hour();
        noTagOver24HourService.insertByTurn(lists);

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(lists);
            System.out.println("NoTagOver24HourAction方法结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("NoTagOver24HourAction方法结束");
    }
}
