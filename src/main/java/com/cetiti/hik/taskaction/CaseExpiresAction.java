package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.CaseExpiresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//行政案件办理期限到期
@Component
public class CaseExpiresAction {
    @Autowired
    private CaseExpiresService caseExpiresService;
    @Scheduled(cron = "${alarmtask4}")
    public void insertCaseExpires() {
        System.out.println(Thread.currentThread().getName()+"进入CaseExpiresAction方法。"+new Date());
        List<CaseInfo> lists10 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists20 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists27 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists28 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists29 = new ArrayList<CaseInfo>();

        List<CaseInfo> lists40 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists50 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists57 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists58 = new ArrayList<CaseInfo>();
        List<CaseInfo> lists59 = new ArrayList<CaseInfo>();

        lists10 = caseExpiresService.getCaseExpires30DaysCase(10,true);
        lists20 = caseExpiresService.getCaseExpires30DaysCase(20,false);
        lists27 = caseExpiresService.getCaseExpires30DaysCase(27,false);
        lists28 = caseExpiresService.getCaseExpires30DaysCase(28,false);
        lists29 = caseExpiresService.getCaseExpires30DaysCase(29,false);

        lists40 = caseExpiresService.getCaseExpires60DaysCase(40,true);
        lists50 = caseExpiresService.getCaseExpires60DaysCase(50,false);
        lists57 = caseExpiresService.getCaseExpires60DaysCase(57,false);
        lists58 = caseExpiresService.getCaseExpires60DaysCase(58,false);
        lists59 = caseExpiresService.getCaseExpires60DaysCase(59,false);
        //插入数据
        caseExpiresService.insertByTurn(lists10, 10, true);
        caseExpiresService.insertByTurn(lists20, 20, true);
        caseExpiresService.insertByTurn(lists27, 27, true);
        caseExpiresService.insertByTurn(lists28, 28, true);
        caseExpiresService.insertByTurn(lists29, 29, true);

        caseExpiresService.insertByTurn(lists40, 40, false);
        caseExpiresService.insertByTurn(lists50, 50, false);
        caseExpiresService.insertByTurn(lists57, 57, false);
        caseExpiresService.insertByTurn(lists58, 58, false);
        caseExpiresService.insertByTurn(lists59, 59, false);

        ////////////////////////////测试-待删除//////////////////////////
        try {
            List listAll = new ArrayList();
            listAll.addAll(lists10);
            listAll.addAll(lists20);
            listAll.addAll(lists27);
            listAll.addAll(lists28);
            listAll.addAll(lists29);
            listAll.addAll(lists40);
            listAll.addAll(lists50);
            listAll.addAll(lists57);
            listAll.addAll(lists58);
            listAll.addAll(lists59);
            System.out.println("CaseExpiresAction结束,插入"+listAll.size());
        } catch (Exception e) {

        }
//        System.out.println("CaseExpiresAction结束");

    }
}
