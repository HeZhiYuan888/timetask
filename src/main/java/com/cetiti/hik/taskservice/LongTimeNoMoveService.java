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
public class LongTimeNoMoveService {

    private static Logger log = LoggerFactory.getLogger(LongTimeNoMoveService.class);

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
    private LongTimeTransactionService longTimeTransactionService;

    @Autowired
    private CommonToolService commonToolService;


    /**
     * 久放未动
     *
     * @return
     */
    public List<CaseInfo> longTimeNoMoveHasSuspect() {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.longTimeNoMoveHasSuspect(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("LongTimeNoMoveService.caseEarlyWarningDao.getDecideResults出错",e);
        }
        return lists;
    }

    public List<CaseInfo> longTimeNoMoveCustodyed() {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.longTimeNoMoveCustodyed(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("LongTimeNoMoveService.caseEarlyWarningDao.getDecideResults出错",e);
        }
        return lists;
    }

    public List<CaseInfo> longTimeNoMoveNoSuspect6(int months) {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.longTimeNoMoveNoSuspect6(months,commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("LongTimeNoMoveService.caseEarlyWarningDao.getDecideResults出错",e);
        }
        return lists;
    }

    public List<CaseInfo> longTimeNoMoveNoSuspect12(int months) {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.longTimeNoMoveNoSuspect12(months,commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("LongTimeNoMoveService.caseEarlyWarningDao.getDecideResults出错",e);
        }
        return lists;
    }

    /**
     * @param caseInfo
     * @param dayOrMonths 已  dayOrMonths（ 天 /月 ）未审阅该案件卷宗
     * @param index       久放未动 序号（1、2、3、4）根据序号，填写对应提醒内容
     * @return
     */

    public CaseAlarm getNearDaysExpiresCaseAlarm(CaseInfo caseInfo, int dayOrMonths, int index) {
        CaseAlarm caseAlarm = new CaseAlarm();
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("LongTimeNoMoveService.caseAlarmDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("longtimeNomove casealarm set 失败");
            return null;
        }
        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("longtimeNomove casealarm setCorpid 失败");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("longtimeNomove casealarm setCreator 失败");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setDictionarytype(104L);
        caseAlarm.setCasechecked(0L);
        if (index == 1) {
            caseAlarm.setAlarmtype(21L);//行政案件30天、到期前三天每天提醒行政案件30天、到期前三天每天提醒
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(21, 104));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("LongTimeNoMoveService.caseEarlyWarningDao.getCaseEarlyWarningID出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称:【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，已" + dayOrMonths + "天未审阅该案件卷宗，请尽快办理。");
        }
        else if (index == 2) {
            caseAlarm.setAlarmtype(22L);//行政案件30天、到期前三天每天提醒行政案件30天、到期前三天每天提醒
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(22, 104));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("LongTimeNoMoveService.caseEarlyWarningDao.getCaseEarlyWarningID出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，已" + dayOrMonths + "天未审阅该案件卷宗，请尽快办理。");
        }
        else if (index == 3) {
            caseAlarm.setAlarmtype(23L);//行政案件30天、到期前三天每天提醒行政案件30天、到期前三天每天提醒
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(23, 104));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("LongTimeNoMoveService.caseEarlyWarningDao.getCaseEarlyWarningID出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" +"，已" + dayOrMonths + "个月未审阅该案件卷宗，请尽快办理。");
        }
        else if (index == 4) {
            caseAlarm.setAlarmtype(24L);//行政案件30天、到期前三天每天提醒行政案件30天、到期前三天每天提醒
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(24, 104));//布控id,对应 caseEarlyWarningId
            } catch (Exception e) {
                log.error("LongTimeNoMoveService.caseEarlyWarningDao.getCaseEarlyWarningID出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" + "，已" + dayOrMonths + "个月未审阅该案件卷宗，请尽快办理。");
        }
        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, int index, boolean isManager) {
        CaseAlarmPerson caseAlarmPerson = new CaseAlarmPerson();
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("LongTimeNoMoveService.caseAlarmPersonDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCaseid(caseInfo.getId());
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
        } catch (Exception e) {
            log.error("longtimenomove casealarmperson setId失败");
            return null;
        }
        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("longtimenomove casealarmperson set失败");
        }
        try {
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("longtimenomove casealarmperson setCorpid失败");
        }
        caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(104L);
        if (!isManager) {
            try {
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("longtimenomove casealarmperson setAlarmuserid失败");
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
                log.error("longtimenomove casealarmperson setAlarmuserid失败");
                return null;
            }
            caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(userInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }

        if (index == 1) {
            caseAlarmPerson.setAlarmtype(21L);
        }
        else if (index == 2) {
            caseAlarmPerson.setAlarmtype(22L);
        }
        else if (index == 3) {
            caseAlarmPerson.setAlarmtype(23L);
        }
        else if (index == 4) {
            caseAlarmPerson.setAlarmtype(24L);
        }

        return caseAlarmPerson;

    }

    public CaseFlowRecord getCaseFlowRecord(CaseInfo caseInfo) {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("LongTimeNoMoveService.caseFlowRecordDao.autoIncreaseId出错",e);
            return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("longtimenomove caseflowrecord setId setCaseid setCasenumber失败");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("longtimenomove caseflowrecord setFlowuserid 失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("longtimenomove caseflowrecord setFlowcorpid 失败");
        }
        caseFlowRecord.setFlowcorpname(commonToolService.judgeNull(caseInfo.getRelegationcorpname()));
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("久放未动提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    /**
     *
     * @param lists
     * @param dayOrMonths 天/月 数
     * @param index 1：连续10天未动提醒
     *              2：连续5天未动提醒
     *              3：自受立案起6个月
     *              4：自受立案起一年
     *
     */
    public void insertByTurn(List<CaseInfo> lists, int dayOrMonths, int index) {
        if (lists != null && lists.size() > 0) {
            for (CaseInfo caseInfo : lists)
            {
                longTimeTransactionService.insertOneByOne(caseInfo,dayOrMonths,index);
            }
        }

    }




}
