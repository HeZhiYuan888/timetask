package com.cetiti.hik.scoreaction;

import com.cetiti.hik.model.Casealarmassessscore;
import com.cetiti.hik.paramVO.CaseAlarmAssessScoreVO;
import com.cetiti.hik.scoreservice.CasealarmTransactionService;
import com.cetiti.hik.scoreservice.CasealarmassessscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CasealarmassessscoreAction {

    @Autowired
    private CasealarmassessscoreService casealarmassessscoreService;

    @Autowired
    private CasealarmTransactionService casealarmTransactionService;

    private Integer[] types = new Integer[]{3,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};
    @Scheduled(cron = "${scoretask1}")
    public void insertToCaseAlarmScoreByType()
    {
        List<Integer> typeList = Arrays.asList(types);
        for(int type:typeList)
        {
            insertByType(type);
        }
    }
    @Scheduled(cron = "${scoretask2}")
    public void insertDetention7()
    {
        List<CaseAlarmAssessScoreVO> detention7Lists = casealarmassessscoreService.getDetention7DayScore();
        insertNoFeedBackScore(detention7Lists);
    }
    @Scheduled(cron = "${scoretask3}")
    public void insertDetention30()
    {
        List<CaseAlarmAssessScoreVO> detention30Lists = casealarmassessscoreService.getDetention30DayScore();
        insertNoFeedBackScore(detention30Lists);
    }
    @Scheduled(cron = "${scoretask4}")
    public void insertBailScore()
    {
        List<CaseAlarmAssessScoreVO> bailScoreLists = casealarmassessscoreService.getBailScore();
        insertNoFeedBackScore(bailScoreLists);
    }
    @Scheduled(cron = "${scoretask5}")
    public void insertSupervisionScore()
    {
        List<CaseAlarmAssessScoreVO> supervisionScoreLists = casealarmassessscoreService.getSupervisionScore();
        insertNoFeedBackScore(supervisionScoreLists);
        System.out.println("插入"+supervisionScoreLists.size());
    }
    @Scheduled(cron = "${scoretask6}")
    public void insertLawsuitScore()
    {
        List<CaseAlarmAssessScoreVO> lawsuitScoreLists = casealarmassessscoreService.getLawsuitScore();
        insertNoFeedBackScore(lawsuitScoreLists);
    }
    @Scheduled(cron = "${scoretask7}")
    public void insertRectificationScore()
    {
        List<CaseAlarmAssessScoreVO> rectificationScoreLists = casealarmassessscoreService.getRectificationScore();
        insertNoFeedBackScore(rectificationScoreLists);
    }
    @Scheduled(cron = "${scoretask8}")
    public void insertPass30DayScore()
    {
        List<CaseAlarmAssessScoreVO> casePass30dayScoreLists = casealarmassessscoreService.getCasePass30dayScore();
        insertNoFeedBackScore(casePass30dayScoreLists);
    }
    @Scheduled(cron = "${scoretask9}")
    public void insertPass60DayScore()
    {
        List<CaseAlarmAssessScoreVO> casePass60dayScoreLists = casealarmassessscoreService.getCasePass60dayScore();
        insertNoFeedBackScore(casePass60dayScoreLists);
    }

    public void insertByType(int alarmType)
    {
        List<CaseAlarmAssessScoreVO> list = casealarmassessscoreService.getCaseAlarmAssessScoreVOByType(alarmType);
        try {
            System.out.println("insertByType查询到带插入数据"+list.size());
        } catch (Exception e) {

        }
        if(list!=null && list.size()>0)
        {
            for(CaseAlarmAssessScoreVO VO:list)
            {
                Casealarmassessscore casealarmassessscore = casealarmassessscoreService.getCasealarmassessscore(VO,1);
                casealarmTransactionService.insertOneByOne(casealarmassessscore);
            }
        }

    }

    public void insertNoFeedBackScore(List<CaseAlarmAssessScoreVO> list)
    {
        if(list!=null && list.size()>0)
        {
            for(CaseAlarmAssessScoreVO VO:list)
            {
                Casealarmassessscore casealarmassessscore = casealarmassessscoreService.getCasealarmassessscore(VO,2);
                casealarmTransactionService.insertOneByOne(casealarmassessscore);
            }
        }
    }




}
