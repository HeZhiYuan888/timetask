package com.cetiti.hik.scoreservice;

import com.cetiti.hik.dao.CaseEarlyWarningMapper;
import com.cetiti.hik.dao.CaseInfoMapper;
import com.cetiti.hik.dao.CasealarmassessscoreMapper;
import com.cetiti.hik.model.Casealarmassessscore;
import com.cetiti.hik.paramVO.CaseAlarmAssessScoreVO;
import com.cetiti.hik.paramVO.CaseInfoParam;
import com.cetiti.hik.taskservice.CommonToolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CasealarmassessscoreService {
    private static Logger log = LoggerFactory.getLogger(CasealarmassessscoreService.class);
    @Autowired
    private CasealarmassessscoreMapper casealarmassessscoreDao;

    @Autowired
    private CaseInfoMapper caseInfoDao;

    @Autowired
    private CaseEarlyWarningMapper caseEarlyWarningDao;

    @Autowired
    private CommonToolService commonToolService;

    @Transactional
    public synchronized void  insertCasealarmassessscore(Casealarmassessscore casealarmassessscore)
    {
        try {
            casealarmassessscoreDao.insertSelective(casealarmassessscore);
        } catch (Exception e) {
            log.error("CasealarmassessscoreService.insertSelective(Line:32)出错",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
    public synchronized long getAutoIncreaseId()
    {
        long currentID = casealarmassessscoreDao.autoIncreaseId();
        updateId(currentID);
        return currentID;

    }
    public synchronized void updateId(long id)
    {
        casealarmassessscoreDao.updateId(id);
    }

    public synchronized void insertAndUpdate(Casealarmassessscore Casealarmassessscore){
        insertCasealarmassessscore(Casealarmassessscore);
    }

    public List<String> getDecisionResults(int type) {
        List<String> decisionResultList = null;
        String decisionResult = "";
        try {
            decisionResult = caseEarlyWarningDao.getDecideResults(type);
        } catch (Exception e) {
            log.error("CasealarmassessscoreService.caseEarlyWarningDao.getDecideResults出错可能caseEarlyWarning表中没有type="+type+"的值",e);
        }
        if (decisionResult!=null && !decisionResult.isEmpty()) {
            String[] results = decisionResult.split(",｜，");
            decisionResultList = Arrays.asList(results);
        }
        return decisionResultList;
    }


    public List<CaseAlarmAssessScoreVO> getCaseAlarmAssessScoreVOByType(int alarmType)
    {
        List<CaseAlarmAssessScoreVO> lists = null;
        try {
            lists = caseInfoDao.getCaseAlarmAssessScoreVOByType(alarmType);
        } catch (Exception e) {
          log.error("getCaseAlarmAssessScoreVOByType出錯",e);
        }
        return lists;
    }

    public List<CaseAlarmAssessScoreVO> getBailScore()
    {
        List<String> decisionResultList = null;
        List<String> list1 = null;
        try {
            decisionResultList = getDecisionResults(31);
        } catch (Exception e) {
            log.error("casealarmtransactionservice getDecisionResults 失败，可能 CaseEarlyWarning中没有type = 31的值");
        }
        List<CaseAlarmAssessScoreVO> lists = null;
        if(decisionResultList!=null && decisionResultList.size()>0)
        {
            list1 =decisionResultList;
            try {
                lists = caseInfoDao.getBailScoreScore(list1);
            } catch (Exception e) {
                log.error("getBailScoreScore出錯",e);
            }
        }
        return lists;
    }

   public List<CaseAlarmAssessScoreVO> getSupervisionScore()
    {
        List<CaseAlarmAssessScoreVO> lists = null;
        List<String> decisionResultList = null;
        List<String> list1 = null;
        decisionResultList = getDecisionResults(32);
        if(decisionResultList!=null && decisionResultList.size()>0)
        {
            list1 = decisionResultList;
            try {
                lists = caseInfoDao.getSupervisionScore(list1);
            } catch (Exception e) {
                log.error("getSupervisionScore出錯",e);
            }
        }

        return lists;
    }

    public List<CaseAlarmAssessScoreVO> getLawsuitScore()
    {
        List<CaseAlarmAssessScoreVO> lists = null;
        List<String> decisionResultList = null;
        List<String> list1 = null;
        decisionResultList = getDecisionResults(33);
        if(decisionResultList!=null && decisionResultList.size()>0)
        {
            list1 = decisionResultList;
            try {
                lists = caseInfoDao.getLawsuitScore(list1);
            } catch (Exception e) {
                log.error("getLawsuitScore出錯",e);
            }
        }
        return lists;
    }
    public List<CaseAlarmAssessScoreVO> getRectificationScore()
    {
        List<CaseAlarmAssessScoreVO> lists = null;
        try {
            lists = caseInfoDao.getRectificationScore();
        } catch (Exception e) {
            log.error("getRectificationScore出錯",e);
        }
        return lists;
    }
    public List<CaseAlarmAssessScoreVO> getCasePass30dayScore()
    {
        List<CaseAlarmAssessScoreVO> lists = null;
        try {
            lists = caseInfoDao.getCasePass30dayScore();
        } catch (Exception e) {
            log.error("getCasePass30dayScore出錯",e);
        }
        return lists;
    }
    public List<CaseAlarmAssessScoreVO> getCasePass60dayScore()
    {
        List<CaseAlarmAssessScoreVO> lists = null;
        try {
            lists = caseInfoDao.getCasePass60dayScore();
        } catch (Exception e) {
            log.error("getCasePass60dayScore出錯",e);
        }
        return lists;
    }


    public List<CaseAlarmAssessScoreVO> getDetention7DayScore()
    {
        List<String> decisionResultList = null;
        List<String> list1 = null;
        decisionResultList = getDecisionResults(29);
        List<CaseAlarmAssessScoreVO> lists = null;
        if (decisionResultList !=null && !decisionResultList.isEmpty())
        {
            list1 = decisionResultList;
            try {
                lists = caseInfoDao.getDetention7DayScore(list1);
            } catch (Exception e) {
                log.error("CasealarmassessscoreService.getDetention30DayScore",e);
            }
        }
        return lists;
    }
    public List<CaseAlarmAssessScoreVO> getDetention30DayScore()
    {
        List<String> list1 = null;
        List<String> list2 = null;
        List<String> decisionResultList29 = getDecisionResults(29);
        List<String> decisionResultList30 = getDecisionResults(30);
        List<CaseAlarmAssessScoreVO> lists = null;
        if (decisionResultList29 !=null && !decisionResultList29.isEmpty() && decisionResultList30!= null && !decisionResultList30.isEmpty())
        {
//            CaseInfoParam caseInfoParam = new CaseInfoParam();
//            caseInfoParam.setList1(decisionResultList29);
//            caseInfoParam.setList2(decisionResultList30);
            list1 = decisionResultList29;
            list2 = decisionResultList30;
            try {
                lists = caseInfoDao.getDetention30DayScore(list1,list2);
            } catch (Exception e) {
                log.error("CasealarmassessscoreService.getDetention30DayScore",e);
            }
        }
        return lists;
    }



    /**
     *
     * @param VO
     * @param countType 计分类型 1：未签收扣分 2： 未反馈扣分
     * @return
     */
    public Casealarmassessscore getCasealarmassessscore(CaseAlarmAssessScoreVO VO,int countType)
    {
        Casealarmassessscore score = new Casealarmassessscore();
        try {
            score.setId(getAutoIncreaseId());
            score.setCaseid(VO.getCaseID());
        } catch (Exception e) {
            log.error("CasealarmassessscoreService.getAutoIncreaseId(Line:65)出错", e);
            return null;
        }
        score.setCasealarmtype(VO.getCaseAlarmType());
        score.setCorpname(commonToolService.judgeNull(VO.getCorpName()));
        score.setEvaluatorusername(commonToolService.judgeNull(VO.getEvaluatorUserName()));
        try {
            score.setCorpid(VO.getCorpID());
            score.setEvaluatoruserid(VO.getEvaluatorUserID());
            score.setCasealarmid(VO.getCaseAlarmID());
        } catch (Exception e) {

        }
        if(countType==1)
        {
            score.setAssessscore(0.1);
            score.setCheckedtype(0L);
            score.setAssesstotal(0.1 * VO.getDays());
        }
        else if(countType==2)
        {
            score.setAssessscore(1);
            score.setCheckedtype(1L);
            score.setAssesstotal(1 * VO.getDays());
        }
        score.setAssessmultiple(1L);
        score.setAssessdate(new Date(System.currentTimeMillis()));
        score.setAssessuserid(1L);
        score.setAssessusername("系统管理员");
        score.setCreatetime(new Date(System.currentTimeMillis()));
        return score;
    }

}
