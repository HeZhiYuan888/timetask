package com.cetiti.hik.taskaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangshuhua@cetiti.com
 * @date 2018-7-16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoTagOver24HourActionTests {

    @Autowired
    NoTagOver24HourAction noTagOver24HourAction;

    @Test
    public void testInsertCabinetAlarm(){
        noTagOver24HourAction.insertNoTagOver24Hour();
    }
}

