package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.RectificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//卷宗整改提醒
@Component
public class RectificationAction {

    @Autowired
    private RectificationService rectificationService;
    @Scheduled(cron = "${alarmtask9}")
    public void insertToRectification() {
        System.out.println(Thread.currentThread().getName()+"进入RectificationAction方法。"+new Date());
        List<CaseInfo> lists = new ArrayList<CaseInfo>();
        lists = rectificationService.getRectification(2);//到期前2天
        rectificationService.insertByTurn(lists);//

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(lists);
            System.out.println("RectificationAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }

        System.out.println("RectificationAction结束");
    }


}
