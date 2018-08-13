package com.cetiti.hik.taskaction;

import com.cetiti.hik.model.CaseAlarm;
import com.cetiti.hik.model.CaseAlarmPerson;
import com.cetiti.hik.taskservice.CaseAlarmPersonService;
import com.cetiti.hik.taskservice.CaseAlarmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangshuhua@cetiti.com
 * @date 2018-7-16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BailActionTests {

    @Autowired
    BailAction bailAction;
    @Autowired
    private CaseAlarmService caseAlarmService;

    @Autowired
    private CaseAlarmPersonService caseAlarmPersonService;


    @Test
    public void testInsertToBail()
    {
        bailAction.insertToBail();
    }
    @Test
    @Transactional
    public void TestTransaction()
    {
        CaseAlarm c1 = new CaseAlarm();
        CaseAlarmPerson c2 = new CaseAlarmPerson();
        c1.setId(1602L);
        c2.setAlarmtype(2L);
        try {
            caseAlarmService.insertAndUpdate(c1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("第一条插入出错");
        }
        try {
            caseAlarmPersonService.insertAndUpdate(c2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("第2条插入出错");
        }
        System.out.println("执行到最后");
    }


}
