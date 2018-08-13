package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.SupervisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//监视居住到期提醒
@Component
public class SupervisionAction {

    @Autowired
    private SupervisionService supervisionService;
    @Scheduled(cron = "${alarmtask10}")
    public void insertToSupervision() {
        System.out.println(Thread.currentThread().getName()+"进入SupervisionAction方法。"+new Date());
        List<CaseInfo> before10DaysLists = new ArrayList<CaseInfo>();
        List<CaseInfo> before3DaysLists = new ArrayList<CaseInfo>();
        List<CaseInfo> before2DaysLists = new ArrayList<CaseInfo>();
        List<CaseInfo> before1DaysLists = new ArrayList<CaseInfo>();

        before10DaysLists = supervisionService.getSupervisionByDay(10);//到期前十天
        before3DaysLists = supervisionService.getSupervisionByDay(3);
        before2DaysLists = supervisionService.getSupervisionByDay(2);
        before1DaysLists = supervisionService.getSupervisionByDay(1);

        supervisionService.insertByTurn(before10DaysLists, 10);//
        supervisionService.insertByTurn(before3DaysLists, 3);//前三天
        supervisionService.insertByTurn(before2DaysLists, 2);//前两天
        supervisionService.insertByTurn(before1DaysLists, 1);//前一天

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(before10DaysLists);
            listAll.addAll(before3DaysLists);
            listAll.addAll(before2DaysLists);
            listAll.addAll(before1DaysLists);
            System.out.println("SupervisionAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("SupervisionAction结束");

    }


}
