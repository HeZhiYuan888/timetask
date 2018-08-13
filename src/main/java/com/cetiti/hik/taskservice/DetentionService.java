package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseAlarmMapper;
import com.cetiti.hik.dao.CaseAlarmPersonMapper;
import com.cetiti.hik.dao.CaseEarlyDecisionResultMapper;
import com.cetiti.hik.dao.CaseEarlyWarningMapper;
import com.cetiti.hik.dao.CaseFlowRecordMapper;
import com.cetiti.hik.dao.CaseInfoMapper;
import com.cetiti.hik.model.CaseAlarm;
import com.cetiti.hik.model.CaseAlarmPerson;
import com.cetiti.hik.model.CaseFlowRecord;
import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.model.UserInfo;
import com.cetiti.hik.paramVO.CaseInfoParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DetentionService {

    private static Logger log = LoggerFactory.getLogger(DetentionService.class);

    @Autowired
    private CaseInfoMapper caseInfoDao;

    @Autowired
    private CaseAlarmService caseAlarmService;

    @Autowired
    private CaseAlarmPersonService caseAlarmPersonService;


    @Autowired
    private CaseFlowRecordService caseFlowRecordService;

    @Autowired
    private CaseEarlyWarningMapper caseEarlyWarningDao;

    @Autowired
    private DetentionTransactionService detentionTransactionService;

    @Autowired
    private CommonToolService commonToolService;


    List<String> getDecisionResults(int type) {
        List<String> decisionResultList = null;
        String decisionResult = "";
        try {
            decisionResult = caseEarlyWarningDao.getDecideResults(type);
        } catch (Exception e) {
            log.error("DetentionService.caseEarlyWarningDao.getDecideResults出错可能caseEarlyWarning表中没有type="+type+"的值",e);
        }
        if (decisionResult!=null && !decisionResult.isEmpty()) {
            String[] results = decisionResult.split(",｜，");
            decisionResultList = Arrays.asList(results);
        }
        return decisionResultList;
    }

    public List<CaseInfo> detention7Days() {
        List<String> decisionResultList = null;
        List<String> list1 = null;
        decisionResultList = getDecisionResults(29);
        List<CaseInfo> list = null;
        if (decisionResultList !=null && !decisionResultList.isEmpty()) {
            list1 = decisionResultList;
            try {
                list = caseInfoDao.detention7Days(list1,commonToolService.beforeSetTime());
            } catch (Exception e) {
                log.error("DetentionService.caseInfoDao.detention7Days出错",e);
            }
        }
        return list;
    }

    public List<CaseInfo> detention7DayAfternoon() {
        List<String> decisionResultList = null;
        List<String> list1 = null;
        decisionResultList = getDecisionResults(29);
        List<CaseInfo> list = null;
        if (decisionResultList !=null && !decisionResultList.isEmpty()) {
            list1 = decisionResultList;
            try {
                list = caseInfoDao.detention7DayAfternoon(list1,commonToolService.beforeSetTime());
            } catch (Exception e) {
                log.error("DetentionService.caseInfoDao.detention7Days出错",e);
            }
        }
        return list;
    }

    /**目前需求：不论是否提醒过，到预警时间点就提醒，即isFirstTime始终为true。
     * 自刑拘起30天（延长）
     * @param days
     * @param isFirstTime true：第一次提醒（不管有无提醒记录，再次生成提醒记录）；
     *                    false：非第一次提醒（第一次提醒过后，后续不再提醒）
     * @return
     */
    public List<CaseInfo> detention30Days(int days,boolean isFirstTime) {
        List<String> list1 = null;
        List<String> list2 = null;
        List<String> decision29ResultList = null;
        List<String> decision30ResultList = null;
        decision29ResultList = getDecisionResults(29);//type=29
        decision30ResultList = getDecisionResults(30);//type=30
        List<CaseInfo> list = null;
        if (decision29ResultList!=null && !decision29ResultList.isEmpty() && decision30ResultList!=null && !decision30ResultList.isEmpty())
        {
//            CaseInfoParam caseInfoParam = new CaseInfoParam();
//            caseInfoParam.setDays(days);
//            caseInfoParam.setList1(decision29ResultList);
//            caseInfoParam.setList2(decision30ResultList);
//            caseInfoParam.setFirstTime(isFirstTime);
            list1 = decision29ResultList;
            list2 = decision30ResultList;
            try {
                list = caseInfoDao.detention30Days(days,list1,list2,isFirstTime,commonToolService.beforeSetTime());
            } catch (Exception e) {
                log.error("DetentionService.caseInfoDao.detention10Days出错",e);
            }
        }
        return list;
    }


    public CaseAlarm getNearDaysExpiresCaseAlarm(CaseInfo caseInfo, int index, int day) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmService.getAutoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmService set失败");
            return null;
        }

        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmService setCorpid失败");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmService setCreator失败");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setDictionarytype(106L);
        caseAlarm.setCasechecked(0L);
        if (index == 1) {
            caseAlarm.setAlarmtype(29L);//
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(29, 106));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmService getCaseEarlyWarningID失败");
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"+"，嫌疑人："+commonToolService.judgeNull(caseInfo.getDxmc())+"，决定时间："+commonToolService.dateToStr(caseInfo.getJdsjdate())+"，嫌疑人已刑事拘留7天，请尽快办理。");
        }
        else if (index == 2) {
            caseAlarm.setAlarmtype(30L);//
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(30, 106));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmService getCaseEarlyWarningID失败");
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"+"，嫌疑人："+commonToolService.judgeNull(caseInfo.getDxmc())+"，决定时间：" +commonToolService.dateToStr(caseInfo.getJdsjdate())+ "，嫌疑人已刑事拘留"+ day + "天，请尽快办理。");
        }
        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, int index, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmPersonDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCaseid(caseInfo.getId());
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmPerson set失败");
            return null;
        }

        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmPerson set失败");
            return null;
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("DetentionService.caseAlarmPerson setCorpid失败");
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(106L);

        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmPerson setAlarmuserid失败");
                return null;
            }
            try {
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmPerson setCreator失败");
            }
            try {
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmPerson setModifier失败");
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(0L);
        } else {
            try {
                caseAlarmPerson.setAlarmuserid(userInfo.getId());
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmPerson setModifier失败");
                return null;
            }
            try {
                caseAlarmPerson.setCreator(userInfo.getId());
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmPerson setCreator失败");
            }
            try {
                caseAlarmPerson.setModifier(userInfo.getId());
            } catch (Exception e) {
                log.error("DetentionService.caseAlarmPerson setModifier失败");
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }

        if (index == 1) {
            caseAlarmPerson.setAlarmtype(29L);
        }
        else if (index == 2) {
            caseAlarmPerson.setAlarmtype(30L);
        }
        return caseAlarmPerson;

    }

    public CaseFlowRecord getToCaseFlowRecord(CaseInfo caseInfo) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("DetentionService.caseFlowRecordDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("DetentionService.caseFlowRecord.set出错",e);
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("DetentionService.caseFlowRecord.setFlowuserid出错");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("DetentionService.caseFlowRecord.setFlowcorpid出错");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseInfo.getRelegationcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("拘留到期提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    /**
     * @param lists
     * @param index 1为自刑拘起7天 类型，2为自刑拘起30天（延长）
     * @param day   第day天提醒
     */
    public void insertByTurn(List<CaseInfo> lists, int index, int day) {
        if (lists != null && lists.size() > 0) {
            for (CaseInfo caseInfo : lists)
            {
                detentionTransactionService.insertOneByOne(caseInfo,index,day);
            }
        }

    }




}
