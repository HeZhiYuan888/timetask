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
public class CaseExpiresService {

    private static Logger log = LoggerFactory.getLogger(CaseExpiresService.class);

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
    private CaseExpireTransactionService caseExpireTransactionService;

    @Autowired
    private CommonToolService commonToolService;

    /**
     * 案件超期三十天
     * @param days 超期天数
     * @param isFirst 是否第一次插入报警数据，第二次插入提醒数据需要查询是否签收
     * @return
     */
    public List<CaseInfo> getCaseExpires30DaysCase(int days,boolean isFirst) {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.casePass30Days(days,isFirst,commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseInfoDao.casePassSomeDays出错",e);
        }
        return lists;
    }

    /**
     * 案件超期六十天
     * @param days 超期天数
     * @param isFirst 是否第一次插入报警数据，第二次插入提醒数据需要查询是否签收
     * @return
     */
    public List<CaseInfo> getCaseExpires60DaysCase(int days,boolean isFirst) {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.casePass60Days(days,isFirst,commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseInfoDao.casePassSomeDays出错",e);
        }
        return lists;
    }

    public CaseAlarm insertNearDaysExpiresCaseAlarm(CaseInfo caseInfo, int days, boolean is30Days) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmService.getAutoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmService.set出错");
            return null;
        }
        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmService.setCorpid出错");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmService.setCreator出错");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setDictionarytype(103L);
        caseAlarm.setCasechecked(0L);
        if (is30Days) {
            caseAlarm.setAlarmtype(19L);//行政案件30天、到期前三天每天提醒行政案件30天、到期前三天每天提醒
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(19, 103));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmService.setCaseearlywarningid出错");
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"
                    +"，立案时间："+commonToolService.dateToStr(caseInfo.getFilingdate())+"，到期时间："+commonToolService.dateToStr(caseInfo.getFinishTime())+
                    "，距案件办理到期还有"+ (30 - days) + "天，请尽快办理。");
        } else {
            caseAlarm.setAlarmtype(20L);//行政案件30天、到期前三天每天提醒行政案件30天、到期前三天每天提醒
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(20, 103));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmService.setCaseearlywarningid出错");
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"
                    +"，立案时间："+commonToolService.dateToStr(caseInfo.getFilingdate())+"，到期时间："+commonToolService.dateToStr(caseInfo.getFinishTime())+
                    "，距案件办理到期还有"+ (60 - days) + "天，请尽快办理。");
        }

        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, boolean is30Days, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmPersonDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCaseid(caseInfo.getId());
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmPersonDao.autoIncreaseId失败",e);
            return null;
        }

        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmPersonDao.setCaseearlywarningid失败",e);
            return null;
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseAlarmPersonDao.setCorpid失败",e);
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(103L);
        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmPersonDao.setAlarmuserid失败",e);
                return null;
            }
            try {
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmPersonDao.setCreator失败",e);
            }
            try {
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmPersonDao.setModifier失败",e);
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(0L);
        } else {
            try {
                caseAlarmPerson.setAlarmuserid(userInfo.getId());
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmPersonDao.setAlarmuserid失败",e);
            }
            try {
                caseAlarmPerson.setCreator(userInfo.getId());
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmPersonDao.setCreator失败",e);
            }
            try {
                caseAlarmPerson.setModifier(userInfo.getId());
            } catch (Exception e) {
                log.error("CaseExpiresService.caseAlarmPersonDao.setModifier失败",e);
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }

        if (is30Days) {
            caseAlarmPerson.setAlarmtype(19L);
        } else {
            caseAlarmPerson.setAlarmtype(20L);
        }
        return caseAlarmPerson;

    }

    public CaseFlowRecord getCaseFlowRecord(CaseInfo caseInfo) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("CaseExpiresService.caseFlowRecordDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("CaseExpiresService.caseFlowRecord setId 或setCaseid 或setCasenumber失败");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseFlowRecord setFlowuserid 失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("CaseExpiresService.caseFlowRecord setFlowcorpid 失败");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseInfo.getRelegationcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("行政案件办理期限到期提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    /**
     *
     * @param lists
     * @param days 到期前days天每天提醒
     *
     * @param is30Days
     */
    public void insertByTurn(List<CaseInfo> lists, int days, boolean is30Days) {
        if (lists != null && lists.size() > 0) {
            for (CaseInfo caseInfo : lists)
            {
                caseExpireTransactionService.insertOneByOne(caseInfo,days,is30Days);
            }
        }

    }




}
