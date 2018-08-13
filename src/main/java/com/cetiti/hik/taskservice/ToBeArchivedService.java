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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ToBeArchivedService {

    private static Logger log = LoggerFactory.getLogger(ToBeArchivedService.class);

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
    private ToBeArchivedTransactionService toBeArchivedTransactionService;

    @Autowired
    private CommonToolService commonToolService;

    public List<CaseInfo> getTobeArchivedFullYear() {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.getTobeArchivedFullYear(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseInfoDao.getTobeArchivedFullYear出错",e);
        }
        return lists;
    }

    public List<CaseInfo> getTobeArchivedProsecution() {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.getTobeArchivedProsecution(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseInfoDao.getTobeArchivedProsecution出错",e);
        }
        return lists;
    }

    public List<CaseInfo> getTobeArchivedNoMove6Month() {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.getTobeArchivedNoMove6Month(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseInfoDao.getTobeArchivedNoMove6Month出错",e);
        }
        return lists;
    }

    public List<CaseInfo> getTobeArchivedNoMove12Month() {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.getTobeArchivedNoMove12Month(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseInfoDao.getTobeArchivedNoMove12Month出错",e);
        }
        return lists;
    }


    public CaseAlarm getNearDaysExpiresCaseAlarm(CaseInfo caseInfo, int index) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseAlarmService.getAutoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("tobearchived casealarm setId 或setCaseid 失败");
            return null;
        }

        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("tobearchived casealarm setCorpid 失败");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("tobearchived casealarm setCreator 失败");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setDictionarytype(105L);
        caseAlarm.setCasechecked(0L);
        if (index == 1) {
            caseAlarm.setAlarmtype(25L);//
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(25, 105));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("tobearchived casealarm caseEarlyWarningDao.getCaseEarlyWarningID 失败");
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，结案时间："+commonToolService.dateToStr(caseInfo.getClosingdate())+"，已结案一年,可归档，请尽快办理。");

        }
        else if (index == 2) {
            caseAlarm.setAlarmtype(26L);//
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(26, 105));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("tobearchived casealarm caseEarlyWarningDao.getCaseEarlyWarningID 失败");
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，决定时间："+commonToolService.dateToStr(caseInfo.getJdsjdate())+"，已移送起诉7天，卷宗副卷可归档，请尽快办理。");

        }
        else if (index == 3) {
            caseAlarm.setAlarmtype(27L);//
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(27, 105));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("tobearchived casealarm caseEarlyWarningDao.getCaseEarlyWarningID 失败");
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，立案时间："+commonToolService.dateToStr(caseInfo.getFilingdate())+"，案件超6月未办结,待归档，请尽快办理。");
        }
        else if (index == 4) {
            caseAlarm.setAlarmtype(28L);//
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(28, 105));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("tobearchived casealarm caseEarlyWarningDao.getCaseEarlyWarningID 失败");
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，立案时间："+commonToolService.dateToStr(caseInfo.getFilingdate())+"，案件超1年未办结,待归档，请尽快办理。");
        }
        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, int index, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseAlarmPersonDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
            caseAlarmPerson.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("tobearchived casealarmperson set 失败");
            return null;
        }
        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("tobearchived casealarmperson setCaseearlywarningid 失败");
            return null;
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("tobearchived casealarmperson setCorpid 失败");
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(105L);
        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("tobearchived casealarmperson setAlarmuserid 失败");
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
                log.error("tobearchived casealarmperson setAlarmuserid 失败");
                return null;
            }
            caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(userInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }

        if (index == 1) {
            caseAlarmPerson.setAlarmtype(25L);
        }
        else if (index == 2) {
            caseAlarmPerson.setAlarmtype(26L);
        }
        else if (index == 3) {
            caseAlarmPerson.setAlarmtype(27L);
        }
        else if (index == 4) {
            caseAlarmPerson.setAlarmtype(28L);
        }

        return caseAlarmPerson;

    }

    public CaseFlowRecord getCaseFlowRecord(CaseInfo caseInfo) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseFlowRecordDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("tobearchived caseflowrecord setId  setCaseid setCasenumber 失败");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("tobearchived caseflowrecord setFlowuserid失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("tobearchived caseflowrecord setFlowcorpid失败");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseInfo.getRelegationcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("待归档提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }
    public void insertByTurn(List<CaseInfo> lists, int index)
    {
        if (lists != null && lists.size() > 0) {
            for (CaseInfo caseInfo : lists)
            {
                toBeArchivedTransactionService.insertOneByOne(caseInfo,index);
            }
        }
    }




}
