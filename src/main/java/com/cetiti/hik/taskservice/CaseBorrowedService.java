package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseAlarmPersonMapper;
import com.cetiti.hik.dao.CaseBorrowedMapper;
import com.cetiti.hik.dao.CaseEarlyWarningMapper;
import com.cetiti.hik.model.CaseAlarm;
import com.cetiti.hik.model.CaseAlarmPerson;
import com.cetiti.hik.model.CaseBorrowed;
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
public class CaseBorrowedService {

    private static Logger log = LoggerFactory.getLogger(CaseBorrowedService.class);

    @Autowired
    private CaseAlarmPersonMapper caseAlarmPersonDao;

    @Autowired
    private CaseAlarmService caseAlarmService;

    @Autowired
    private CaseAlarmPersonService caseAlarmPersonService;

    @Autowired
    private CaseInfoService caseInfoService;


    @Autowired
    private CaseFlowRecordService caseFlowRecordService;

    @Autowired
    private CaseEarlyWarningMapper caseEarlyWarningDao;

    @Autowired
    private CaseBorrowedMapper caseBorrowedDao;

    @Autowired
    private CaseBorrowTransactionService caseBorrowTransactionService;

    @Autowired
    private CommonToolService commonToolService;


    public synchronized long getAutoIncreaseId() {
        return caseAlarmPersonDao.autoIncreaseId();
    }

    public List<CaseBorrowed> getCaseBorrowOverOneDay() {
        return caseBorrowedDao.getCaseBorrowOverOneDay(commonToolService.beforeSetTime());
    }

    public List<CaseBorrowed> getCaseBorrowOverThreeDay() {
        return caseBorrowedDao.getCaseBorrowOverThreeDay(commonToolService.beforeSetTime());
    }

    public CaseInfo getCaseInfoByCaseNumber(String number) {
        return caseInfoService.getCaseInfo(number);
    }

    public CaseAlarm getOverDateCaseAlarm(CaseBorrowed caseBorrowed, Boolean is24Hour) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("CaseBorrowedService.caseAlarmService.getAutoIncreaseId出错",e);
            return null;
        }
        CaseInfo caseInfo = getCaseInfoByCaseNumber(commonToolService.judgeNull(caseBorrowed.getCasenumber()));
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseBorrowed.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("CaseBorrowedService.caseAlarmService.setCaseAlarm出错",e);
            return null;
        }
        caseAlarm.setEpc(commonToolService.judgeNull(caseBorrowed.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("CaseBorrowedService.caseAlarmService.setCorpid出错",e);
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("CaseBorrowedService.caseAlarmService.setCreator出错",e);
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);//预警状态
        caseAlarm.setDictionarytype(100L);
        caseAlarm.setCasechecked(0L);
        if (is24Hour) {
            caseAlarm.setAlarmtype(13L);
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(13, 100));
            } catch (Exception e) {
                log.error("CaseBorrowedService.caseAlarmService.setCaseearlywarningid出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" +"，借阅时间："+commonToolService.dateToStr(caseBorrowed.getBorroweddate())+ "，被借阅24小时未归还，请尽快办理。");
        } else {
            caseAlarm.setAlarmtype(14L);
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(14, 100));
            } catch (Exception e) {
                log.error("CaseBorrowedService.caseAlarmService.setCaseearlywarningid出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" +"，借阅时间："+commonToolService.dateToStr(caseBorrowed.getBorroweddate())+ "，被借阅72小时未归还，请尽快办理。");
        }
        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseBorrowed caseBorrowed, CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, boolean is24Hour, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("CaseBorrowedService.caseAlarmPersonDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseBorrowed.getCasenumber()));
            caseAlarmPerson.setCaseid(caseInfo.getId());
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
        } catch (Exception e) {
            log.error("CaseBorrowedService.setCaseAlarmPerson setId setCaseid setCasealarmid出错",e);
            return null;
        }

        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseBorrowed.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("caseBorrow set caseearlywarningid失败",e);
            return null;
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("caseBorrow set setCorpid失败",e);
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);
        caseAlarmPerson.setAlarmstate(1L);
        caseAlarmPerson.setDictionarytype(100L);
        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("caseBorrow set setAlarmuserid失败",e);
                return null;
            }
            try {
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("caseBorrow set setCreator失败",e);
            }
            try {
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("caseBorrow set setModifier失败",e);
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(0L);
        } else {
            try {
                caseAlarmPerson.setAlarmuserid(userInfo.getId());
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            } catch (Exception e) {
                log.error("caseBorrow set setAlarmuserid失败",e);
            }
            try {
                caseAlarmPerson.setCreator(userInfo.getId());
            } catch (Exception e) {
                log.error("caseBorrow set setCreator失败",e);
            }
            try {
                caseAlarmPerson.setModifier(userInfo.getId());
            } catch (Exception e) {
                log.error("caseBorrow set setModifier失败",e);
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }

        if (is24Hour) {
            caseAlarmPerson.setAlarmtype(13L);
        }
        else {
            caseAlarmPerson.setAlarmtype(14L);
        }
        return caseAlarmPerson;

    }

    public CaseFlowRecord getOverDateCaseFlowRecord(CaseBorrowed caseBorrowed) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("CaseBorrowedService.caseFlowRecordDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseBorrowed.getCaseid());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseBorrowed.getCasenumber()));
        } catch (Exception e) {
            log.error("caseBorrowed.getBorroweduserid set id或caseid或casenumber失败");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseBorrowed.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseBorrowed.getBorroweduserid());
        } catch (Exception e) {
            log.error("caseBorrowed.getBorroweduserid setFlowuserid失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseBorrowed.getBorrowedusername()));
        try {
            caseFlowRecord.setFlowcorpid(caseBorrowed.getBorrowedcorpid());
        } catch (Exception e) {
            log.error("caseBorrowed.getBorroweduserid setFlowcorpid失败");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseBorrowed.getBorrowedcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("借阅超期提醒");
        caseFlowRecord.setState(1L);
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    /**
     *
     * @param lists
     * @param is24Hour true: 自借阅时间开始起24小时未归还
     *                 false: 自借阅时间开始起72小时未归还
     */
    public void insertByTurn(List<CaseBorrowed> lists, boolean is24Hour) {
        if (lists != null && lists.size() > 0)
        {
            for (CaseBorrowed caseBorrowed : lists)
            {
                caseBorrowTransactionService.insertOneByOne(caseBorrowed,is24Hour);
            }
        }
    }


}
