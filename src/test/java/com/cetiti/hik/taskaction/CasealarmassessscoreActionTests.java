package com.cetiti.hik.taskaction;

import com.cetiti.hik.scoreaction.CasealarmassessscoreAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CasealarmassessscoreActionTests {
    @Autowired
    private CasealarmassessscoreAction casealarmassessscoreAction;
    @Test
    public void testScoreByType(){
        casealarmassessscoreAction.insertToCaseAlarmScoreByType();
    }

    @Test
    public void testScoreFeedBack(){
        casealarmassessscoreAction.insertRectificationScore();
    }



}
