package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseAlarmMapper;
import com.cetiti.hik.dao.CaseAlarmPersonMapper;
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
public class LawsuitService {

    private static Logger log = LoggerFactory.getLogger(LawsuitService.class);

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
    private LawsuitTransactionService lawsuitTransactionService;

    @Autowired
    private CommonToolService commonToolService;


    List<String> getDecisionResults(int type) {
        List<String> decisionResultList = null;
        String decisionResult = "";
        try {
            decisionResult = caseEarlyWarningDao.getDecideResults(type);
        } catch (Exception e) {
            log.error("LawsuitService.caseEarlyWarningDao.getDecideResults出错，可能 CaseEarlyWarning表中没有type = "+type+"的值",e);
        }
        if (decisionResult!=null && !decisionResult.isEmpty()) {
            String[] results = decisionResult.split(",");
            decisionResultList = Arrays.asList(results);
        }
        return decisionResultList;
    }

    public List<CaseInfo> getLawsuitByMonth(int months) {
        List<String> decisionResultList = null;
        List<String> list1 = null;
        decisionResultList = getDecisionResults(33);
        List<CaseInfo> list = null;
        if (decisionResultList !=null &&!decisionResultList.isEmpty()) {
//            CaseInfoParam caseInfoParam = new CaseInfoParam();
//            caseInfoParam.setMonths(months);
//            caseInfoParam.setList1(decisionResultList);
            list1 = decisionResultList;
            try {
                list = caseInfoDao.getLawsuitByMonth( months,list1,commonToolService.beforeSetTime());
            } catch (Exception e) {
                log.error("LawsuitService..caseEarlyWarningDao.getDecideResults出错",e);
            }
        }
        return list;
    }

    public List<CaseInfo> getLawsuitByDay(int days) {
        List<String> decisionResultList = null;
        decisionResultList = getDecisionResults(33);
        List<String> list1 = null;
        List<CaseInfo> list = null;
        if (decisionResultList !=null && !decisionResultList.isEmpty()) {
//            CaseInfoParam caseInfoParam = new CaseInfoParam();
//            caseInfoParam.setDays(days);
            list1 = decisionResultList;
            try {
                list = caseInfoDao.getLawsuitByDay(days,list1,commonToolService.beforeSetTime());
            } catch (Exception e) {
                log.error("LawsuitService.caseEarlyWarningDao.getDecideResults出错",e);
            }
        }
        return list;
    }


    /**
     * @param caseInfo
     * @param index      1 为 按月 ，2 为按天
     * @param dayOrMonth 移诉提醒 月/天 数
     * @return
     */
    public CaseAlarm getNearDaysExpiresCaseAlarm(CaseInfo caseInfo, int index, int dayOrMonth) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("LawsuitService.caseAlarmService.getAutoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("LawsuitService.caseAlarmService set失败");
            return null;
        }
        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("LawsuitService.caseAlarmService setCorpid失败");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("LawsuitService.caseAlarmService setCreator失败");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setDictionarytype(109L);
        caseAlarm.setAlarmtype(33L);//报警类型
        caseAlarm.setCasechecked(0L);
        try {
            caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(33, 109));//布控id,对应 caseEarlyWarningId
        } catch (Exception e) {
            log.error("LawsuitService.caseAlarmService caseEarlyWarningDao.getCaseEarlyWarningID失败");
            return null;
        }

        if (index == 1) {
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"+"，嫌疑人："+commonToolService.judgeNull(caseInfo.getDxmc())+"，决定时间："+commonToolService.dateToStr(caseInfo.getJdsjdate())+",批准逮捕，已"+dayOrMonth+"个月，请尽快办理。");
        }
        else if (index == 2) {
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"+"，嫌疑人："+commonToolService.judgeNull(caseInfo.getDxmc())+"，决定时间："+commonToolService.dateToStr(caseInfo.getJdsjdate())+",批准逮捕，距离到期还有"+dayOrMonth+"天，请尽快办理。");
        }
        return caseAlarm;
    }

    public CaseAlarmPerson insertOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("LawsuitService.caseAlarmPersonDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCaseid(caseInfo.getId());
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
        } catch (Exception e) {
            log.error("lawsuit casealarmperson set失败");
            return null;
        }
        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("lawsuit casealarmperson set 失败");
            return null;
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("lawsuit casealarmperson setCorpid 失败");
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(109L);

        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("lawsuit casealarmperson setAlarmuserid 失败");
                return null;
            }
            caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
            try {
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("lawsuit casealarmperson setCreator 失败");
            }
            try {
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("lawsuit casealarmperson setModifier 失败");
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(0L);
        } else {
            try {
                caseAlarmPerson.setAlarmuserid(userInfo.getId());
                caseAlarmPerson.setCreator(userInfo.getId());
                caseAlarmPerson.setModifier(userInfo.getId());
            } catch (Exception e) {
                log.error("lawsuit casealarmperson setModifier 失败");
                return null;
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }
        caseAlarmPerson.setAlarmtype(33L);
        return caseAlarmPerson;

    }

    public CaseFlowRecord insertToCaseFlowRecord(CaseInfo caseInfo) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("LawsuitService.caseFlowRecordDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("lawsuit caseFlowRecord setId 或setCaseid 或setCasenumber失败");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("lawsuit caseFlowRecord setFlowuserid 失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("lawsuit caseFlowRecord setFlowcorpid 失败");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseInfo.getRelegationcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("移诉提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    /**
     * @param lists
     * @param index 1：为每个月提醒一次
     *              2：到期前3天每天提醒一次
     * @param day   第day天提醒
     */
    public void insertByTurn(List<CaseInfo> lists, int index, int day) {
        if (lists != null && lists.size() > 0)
        {
            for (CaseInfo caseInfo : lists)
            {
                lawsuitTransactionService.insertOneByOne(caseInfo,index,day);
            }
        }

    }



}
