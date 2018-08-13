package com.cetiti.hik.scoreservice;

import com.cetiti.hik.model.Casealarmassessscore;
import com.cetiti.hik.paramVO.CaseAlarmAssessScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CasealarmTransactionService {

    @Autowired
    private  CasealarmassessscoreService casealarmassessscoreService;

    public void insertOneByOne( Casealarmassessscore casealarmassessscore)
    {
        if(casealarmassessscore.getAssesstotal()!=0.0 || casealarmassessscore.getAssesstotal()!=0)
        {
            casealarmassessscoreService.insertCasealarmassessscore(casealarmassessscore);
        }
    }
}
