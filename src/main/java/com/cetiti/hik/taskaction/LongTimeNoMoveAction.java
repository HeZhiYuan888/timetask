package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.LongTimeNoMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//久放未动提醒
@Component
public class LongTimeNoMoveAction {
    @Autowired
    private LongTimeNoMoveService longTimeNoMoveService;
    @Scheduled(cron = "${alarmtask7}")
    public void insertLongTimeNoMove() {
        List listAll = new ArrayList();
        System.out.println(Thread.currentThread().getName()+"进入LongTimeNoMoveAction方法。"+new Date());
//        自上一次入柜起，连续10天未动提醒
        List<CaseInfo> lists10 = new ArrayList<CaseInfo>();
        lists10 = longTimeNoMoveService.longTimeNoMoveHasSuspect();
//        自上一次入柜起，连续5天未动提醒
        List<CaseInfo> lists5 = new ArrayList<CaseInfo>();
        lists5 = longTimeNoMoveService.longTimeNoMoveCustodyed();

        longTimeNoMoveService.insertByTurn(lists10, 10, 1);
        longTimeNoMoveService.insertByTurn(lists5, 5, 2);
        //        自受立案起6个月 ，每个月提醒一次，最后一个月不用
        for (int i = 1; i < 6; i++) {
            List<CaseInfo> lists3 = longTimeNoMoveService.longTimeNoMoveNoSuspect6(i);
            longTimeNoMoveService.insertByTurn(lists3, i, 3);
            listAll.addAll(lists3);
        }
        //        自受立案起一年，每个月提醒一次，最后一个月不用
        for (int i = 1; i < 12; i++) {
            List<CaseInfo> lists4 = longTimeNoMoveService.longTimeNoMoveNoSuspect12(i);
            longTimeNoMoveService.insertByTurn(lists4, i, 4);
            listAll.addAll(lists4);
        }

        ////////////////////////////测试-待删除//////////////////////////
        try {
            listAll.addAll(lists10);
            listAll.addAll(lists5);
            System.out.println("insertLongTimeNoMove结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("insertLongTimeNoMove结束");
    }


}
