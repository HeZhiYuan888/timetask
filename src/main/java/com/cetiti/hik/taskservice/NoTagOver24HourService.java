package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseEarlyWarningMapper;
import com.cetiti.hik.dao.CaseInfoMapper;
import com.cetiti.hik.model.CaseAlarm;
import com.cetiti.hik.model.CaseAlarmPerson;
import com.cetiti.hik.model.CaseFlowRecord;
import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoTagOver24HourService {

    private static Logger log = LoggerFactory.getLogger(NoTagOver24HourService.class);

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
    private NoTagTransactionService noTagTransactionService;

    @Autowired
    private CommonToolService commonToolService;

    public List<CaseInfo> getNoTagOver24Hour() {
        return caseInfoDao.getNoTagOver24Hour(commonToolService.beforeSetTime());
    }

    public CaseAlarm getOverOneDayCaseAlarm(CaseInfo caseInfo) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("NoTagOver24HourService.caseAlarmService.getAutoIncreaseId出错", e);
            return null;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("notagover24 casealarm setId 或setCaseid失败");
            return null;
        }
        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("notagover24 casealarm setCorpid失败");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("notagover24 casealarm setCreator失败");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setAlarmtype(3L);//未贴标签
        try {
            caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(3, 102));//无标签
        } catch (Exception e) {
            log.error("notagover24 casealarm caseEarlyWarningDao.getCaseEarlyWarningID失败");
            return null;
        }
        caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，立案24小时未贴标签，请尽快办理。");
        caseAlarm.setDictionarytype(102L);
        caseAlarm.setCasechecked(0L);
        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("NoTagOver24HourService.caseAlarmPersonDao.autoIncreaseId出错", e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCaseid(caseInfo.getId());
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
        } catch (Exception e) {
            log.error("notagover24 casealarmperson set 失败");
            return null;
        }
        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("notagover24 casealarmperson set 失败");
            return null;
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("notagover24 casealarmperson setCorpid 失败");
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(102L);
        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("notagover24 casealarmperson setAlarmuserid 失败");
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
                log.error("notagover24 casealarmperson setAlarmuserid 失败");
            }
            caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(userInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }
        caseAlarmPerson.setAlarmtype(3L);//未贴标签
        return caseAlarmPerson;

    }

    public CaseFlowRecord getCaseFlowRecord(CaseInfo caseInfo) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("NoTagOver24HourService.caseFlowRecordDao.autoIncreaseId出错", e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("notagover24 casealarmperson setId setCaseid setCasenumber 失败");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("notagover24 casealarmperson setFlowuserid 失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("notagover24 casealarmperson setFlowcorpid 失败");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseInfo.getRelegationcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("未贴标签提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    public void insertByTurn(List<CaseInfo> lists) {
        if (lists != null && lists.size() > 0) {
            //***********************插入CaseAlarm表-开始***********************//
            for (CaseInfo caseInfo : lists) {
                noTagTransactionService.insertOneByOne(caseInfo);
            }
        }
    }


}
