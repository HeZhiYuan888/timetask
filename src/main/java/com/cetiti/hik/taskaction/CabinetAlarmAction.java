package com.cetiti.hik.taskaction;


import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.CabinetAlarmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CabinetAlarmAction {

    public static Logger log = LoggerFactory.getLogger(CabinetAlarmAction.class);

    @Autowired
    private CabinetAlarmService cabinetAlarmService;
    @Scheduled(cron = "${alarmtask2}")
    public void insertCabinetAlarm() {
        System.out.println(Thread.currentThread().getName()+"进入CabinetAlarmAction.insertCabinetAlarm方法。"+new Date());
        List<CaseInfo> leftCabinetOverOneDayLists = new ArrayList<CaseInfo>();
        List<CaseInfo> leftCabinetOverThreeDayLists = new ArrayList<CaseInfo>();
        List<CaseInfo> returnOverOneDayLists = new ArrayList<CaseInfo>();
        List<CaseInfo> returnOverThreeDayLists = new ArrayList<CaseInfo>();

        leftCabinetOverOneDayLists = cabinetAlarmService.getLeftCabinetOverOneDayCaseInfo();//自离柜时间起24小时
        leftCabinetOverThreeDayLists = cabinetAlarmService.getLeftCabinetOverThreeDaysCaseInfo();//自离柜时间起72小时
        returnOverOneDayLists = cabinetAlarmService.getReturnOverOneDayCaseInfo();//自返还时间起24小时
        returnOverThreeDayLists = cabinetAlarmService.getReturnOverThreeDaysCaseInfo();//自返还时间起72小时
        //插入数据
        cabinetAlarmService.insertByTurn(leftCabinetOverOneDayLists, 1);
        cabinetAlarmService.insertByTurn(leftCabinetOverThreeDayLists, 2);
        cabinetAlarmService.insertByTurn(returnOverOneDayLists, 3);
        cabinetAlarmService.insertByTurn(returnOverThreeDayLists, 4);

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(leftCabinetOverOneDayLists);
            listAll.addAll(leftCabinetOverThreeDayLists);
            listAll.addAll(returnOverOneDayLists);
            listAll.addAll(returnOverThreeDayLists);
            System.out.println("CabinetAlarmAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
    }
}
