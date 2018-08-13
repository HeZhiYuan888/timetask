package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseEarlyWarningMapper;
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
public class SupervisionService {

    private static Logger log = LoggerFactory.getLogger(SupervisionService.class);

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
    private SupervisionTransactionService supervisionTransactionService;

    @Autowired
    private CommonToolService commonToolService;


    List<String> getDecisionResults(int type) {
        List<String> decisionResultList = null;
        String decisionResult = "";
        try {
            decisionResult = caseEarlyWarningDao.getDecideResults(type);
        } catch (Exception e) {
            log.error("SupervisionService.caseEarlyWarningDao.getDecideResults出错，可能caseEarlyWarning表中没有type="+type+"的值",e);
        }
        if (decisionResult!=null && !decisionResult.isEmpty()) {
            String[] results = decisionResult.split(",｜，");
            decisionResultList = Arrays.asList(results);
        }
        return decisionResultList;
    }

    public List<CaseInfo> getSupervisionByDay(int days) {
        List<String> decisionResultList = null;
        List<String> list1 = null;
        decisionResultList = getDecisionResults(32);
        List<CaseInfo> list = null;
        if (decisionResultList!=null && !decisionResultList.isEmpty()) {
//            CaseInfoParam caseInfoParam = new CaseInfoParam();
//            caseInfoParam.setDays(days);
//            caseInfoParam.setList1(decisionResultList);
            list1 = decisionResultList;
            try {
                list = caseInfoDao.getSupervisionByDay(days,list1,commonToolService.beforeSetTime());
            } catch (Exception e) {
                log.error("SupervisionService.caseInfoDao.getSupervisionByDay出错",e);
            }
        }
        return list;
    }


    /**
     * @param caseInfo
     * @param days     到期前10天提醒一次，到期前3天每天提醒一次
     * @return
     */
    public CaseAlarm getNearDaysExpiresCaseAlarm(CaseInfo caseInfo, int days) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("SupervisionService.caseAlarmService.getAutoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("supervision casealarm set 失败");
            return null;
        }
        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("supervision casealarm setCorpid 失败");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("supervision casealarm setCreator 失败");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setDictionarytype(108L);
        caseAlarm.setAlarmtype(32L);//报警类型
        caseAlarm.setCasechecked(0L);
        try {
            caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(32, 108));//布控id,对应 caseEarlyWarningId
        } catch (Exception e) {
            log.error("supervision casealarm caseEarlyWarningDao.getCaseEarlyWarningID 失败");
        }
        caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename())+ "】"+"，嫌疑人："+commonToolService.judgeNull(caseInfo.getDxmc())+"，决定时间："+commonToolService.dateToStr(caseInfo.getJdsjdate())+"开始监视居住，距离到期还有"+days+"天，请尽快办理。");
        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("SupervisionService.caseAlarmPersonDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCaseid(caseInfo.getId());
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
        } catch (Exception e) {
            log.error("supervision casealarmperson setId 失败");
            return null;
        }
        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("supervision casealarmperson setCaseearlywarningid 失败");
            return null;
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("supervision casealarmperson setCorpid 失败");
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(108L);

        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("supervision casealarmperson setCorpid 失败");
                return null;
            }
            caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(0L);
        } else {
            try {
                caseAlarmPerson.setAlarmuserid(userInfo.getId());
                caseAlarmPerson.setCreator(userInfo.getId());
                caseAlarmPerson.setModifier(userInfo.getId());
            } catch (Exception e) {
                log.error("supervision casealarmperson setCorpid 失败");
                return null;
            }
            caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(userInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }
        caseAlarmPerson.setAlarmtype(32L);
        return caseAlarmPerson;

    }

    public CaseFlowRecord getCaseFlowRecord(CaseInfo caseInfo) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("SupervisionService.caseFlowRecordDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("supervision caseflowrecord setId setCaseid  setCasenumber 失败");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("supervision caseflowrecord setFlowuserid 失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("supervision caseflowrecord setFlowcorpid 失败");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseInfo.getRelegationcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("监视居住到期提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    /**
     * @param lists
     * @param day   第day天提醒
     */
    public void insertByTurn(List<CaseInfo> lists, int day) {
        if (lists != null && lists.size() > 0) {
            for (CaseInfo caseInfo : lists)
            {
                supervisionTransactionService.insertOneByOne(caseInfo,day);
            }
        }

    }




}
