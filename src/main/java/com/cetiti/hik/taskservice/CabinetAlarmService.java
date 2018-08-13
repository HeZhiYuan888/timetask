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
public class CabinetAlarmService {

    private static Logger log = LoggerFactory.getLogger(CabinetAlarmService.class);

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
    private CabinetTransactionService cabinetTransactionService;

    @Autowired
    private CommonToolService commonToolService;


    public List<CaseInfo> getLeftCabinetOverOneDayCaseInfo()
    {
        List<CaseInfo> lists = null;

        try {
            lists = caseInfoDao.getLeftCabinetOverOneDayCaseInfo(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("CabinetAlarmService.caseInfoDao.getLeftCabinetOverOneDayCaseInfo出错",e);
        }
        return lists;
    }
    public List<CaseInfo> getLeftCabinetOverThreeDaysCaseInfo()
    {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.getLeftCabinetOverThreeDaysCaseInfo(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("CabinetAlarmService.caseInfoDao.getLeftCabinetOverThreeDaysCaseInfo出错",e);
        }
        return lists;
    }
    public List<CaseInfo> getReturnOverOneDayCaseInfo()
    {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.getReturnOverOneDayCaseInfo(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("CabinetAlarmService.caseInfoDao.getReturnOverOneDayCaseInfo出错",e);
        }
        return lists;
    }

    public List<CaseInfo> getReturnOverThreeDaysCaseInfo()
    {
        List<CaseInfo> lists = null;
        try {
            lists = caseInfoDao.getReturnOverThreeDaysCaseInfo(commonToolService.beforeSetTime());
        } catch (Exception e) {
            log.error("CabinetAlarmService.caseInfoDao.getReturnOverThreeDaysCaseInfo出错",e);
        }
        return lists;
    }

    public CaseAlarm getOverOneDayCaseAlarm(CaseInfo caseInfo, int index )
    {
        CaseAlarm caseAlarm = new CaseAlarm();//这里也一样
        long cl_id = 0;
        try {
            cl_id = caseAlarmService.getAutoIncreaseId();
        } catch (Exception e) {
            log.error("CabinetAlarmService.caseAlarmDao.autoIncreaseId出错",e);
            cl_id = 1L;
        }
        try {
            caseAlarm.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarm.setId(cl_id);
            caseAlarm.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("CabinetAlarmService.set出错");
            return null;
        }
        caseAlarm.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarm.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarm.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("CabinetAlarmService.setCorpid失败");
        }
        caseAlarm.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
        try {
            caseAlarm.setCreator(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("CabinetAlarmService.setCreator失败");
        }
        caseAlarm.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarm.setState(1L);
        caseAlarm.setAlarmstate(1L);
        caseAlarm.setDictionarytype(101L);
        caseAlarm.setCasechecked(0L);
        if(index==1)
        {
            caseAlarm.setAlarmtype(15L);
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(15,101));
            } catch (Exception e) {
                log.error("CabinetAlarmService.caseEarlyWarningDao.getCaseEarlyWarningID出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" +
                    "，离柜时间："+commonToolService.dateToStr(caseInfo.getCabinetinoutdate())+
                    "，离柜24小时未归还，请尽快办理。");
        }
        else if(index==2)
        {
            caseAlarm.setAlarmtype(16L);
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(16,101));
            } catch (Exception e) {
                log.error("CabinetAlarmService.caseEarlyWarningDao.getCaseEarlyWarningID出错",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】" +
                    "，离柜时间：" +commonToolService.dateToStr(caseInfo.getCabinetinoutdate())+
                    "，离柜72小时未归还，请尽快办理。");
        }
        else if(index==3)
        {
            caseAlarm.setAlarmtype(17L);
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(17,101));
            } catch (Exception e) {
                log.error("CabinetAlarmService.caseEarlyWarningDao.getCaseEarlyWarningID失败",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"
                    + "，离柜时间："+commonToolService.dateToStr(caseInfo.getCabinetinoutdate())
                    +"，卷宗发还24小时未入柜，请尽快办理。");
        }
        else if(index==4)
        {
            caseAlarm.setAlarmtype(18L);
            try {
                caseAlarm.setCaseearlywarningid(caseEarlyWarningDao.getCaseEarlyWarningID(18,101));
            } catch (Exception e) {
                log.error("CabinetAlarmService.caseEarlyWarningDao.getCaseEarlyWarningID失败",e);
                return null;
            }
            caseAlarm.setAlarmcontent("案件编号：【" + commonToolService.judgeNull(caseInfo.getCasenumber()) + "】，案件名称：【" + commonToolService.judgeNull(caseInfo.getCasename()) + "】"
                    + "，离柜时间："+commonToolService.dateToStr(caseInfo.getCabinetinoutdate())
                    +"，卷宗发还72小时未入柜，请尽快办理。");
        }
        return caseAlarm;
    }

    public CaseAlarmPerson getOverDateCaseAlarmPerson(CaseAlarm caseAlarm, CaseInfo caseInfo, UserInfo userInfo, int index, boolean isManager)
    {
        //这里
        CaseAlarmPerson caseAlarmPerson =  new CaseAlarmPerson();//这里你已经是new出来了，肯定不是null
        long clp_id = 0;
        try {
            clp_id = caseAlarmPersonService.getAutoIncreaseId();
        } catch (Exception e) {
           log.error("CabinetAlarmService.caseAlarmPersonDao.autoIncreaseId出错",e);
           return null;
        }
        try {
            caseAlarmPerson.setId(clp_id);
            caseAlarmPerson.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
            caseAlarmPerson.setCasealarmid(caseAlarm.getId());
            caseAlarmPerson.setCaseid(caseInfo.getId());
        } catch (Exception e) {
            log.error("Cabinet.CaseAlarmPerson setId setCasealarmid setCaseid 出错");
            return null;
        }
        caseAlarmPerson.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        caseAlarmPerson.setAlarmtime(new Date(System.currentTimeMillis()));
        try {
            caseAlarmPerson.setCaseearlywarningid(caseAlarm.getCaseearlywarningid());
        } catch (Exception e) {
            log.error("Cabinet.CaseAlarmPerson setCaseearlywarningid失败");
            return null;
        }
        try {
            caseAlarmPerson.setCorpname(commonToolService.judgeNull(caseInfo.getCorpname()));
            caseAlarmPerson.setCorpid(caseInfo.getCorpid());
        } catch (Exception e) {
            log.error("Cabinet.CaseAlarmPerson setCorpid失败");
        }
        caseAlarmPerson.setIsread(0L);//1：是；0：否
        caseAlarmPerson.setCreatetime(new Date(System.currentTimeMillis()));
        caseAlarmPerson.setState(1L);//0:撤销；1:启用
        caseAlarmPerson.setAlarmstate(1L);//0：预警；1：告警；2：超期告警
        caseAlarmPerson.setDictionarytype(101L);
        if(!isManager)
        {
            try {
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
                caseAlarmPerson.setAlarmuserid(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("Cabinet.CaseAlarmPerson setAlarmuserid失败");
                return null;
            }
            try {
                caseAlarmPerson.setCreator(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("Cabinet.CaseAlarmPerson setCreator失败");
            }
            try {
                caseAlarmPerson.setModifier(caseInfo.getOrganiserid());
            } catch (Exception e) {
                log.error("Cabinet.CaseAlarmPerson setModifier失败");
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(caseInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(0L);
        }
        else
        {
            try {
                caseAlarmPerson.setAlarmuserid(userInfo.getId());
                caseAlarmPerson.setAlarmusername(commonToolService.judgeNull(userInfo.getName()));
            } catch (Exception e) {
                log.error("Cabinet.CaseAlarmPerson setAlarmuserid失败");
                return null;
            }
            try {
                caseAlarmPerson.setCreator(userInfo.getId());
            } catch (Exception e) {
                log.error("Cabinet.CaseAlarmPerson setCreator失败");
            }
            try {
                caseAlarmPerson.setModifier(userInfo.getId());
            } catch (Exception e) {
                log.error("Cabinet.CaseAlarmPerson setModifier失败");
            }
            caseAlarmPerson.setAlarmuserpoliceid(commonToolService.judgeNull(userInfo.getUserpoliceid()));
            caseAlarmPerson.setIscasechecked(1L);
        }

        if(index==1)
        {
            caseAlarmPerson.setAlarmtype(15L);
        }
        else if(index==2)
        {
            caseAlarmPerson.setAlarmtype(16L);
        }
        else if(index==3)
        {
            caseAlarmPerson.setAlarmtype(17L);
        }
        else if(index==4)
        {
            caseAlarmPerson.setAlarmtype(18L);
        }
        return caseAlarmPerson;

    }
    public CaseFlowRecord getCaseFlowRecord(CaseInfo caseInfo)
    {
        CaseFlowRecord caseFlowRecord = new CaseFlowRecord();
        long clr_id = 0;
        try {
            clr_id = caseFlowRecordService.getAutoIncreaseId();
        } catch (Exception e) {
          log.error("CabinetAlarmService.caseFlowRecordDao.autoIncreaseId出错",e);
          return null;
        }
        try {
            caseFlowRecord.setId(clr_id);
            caseFlowRecord.setCaseid(caseInfo.getId());
            caseFlowRecord.setCasenumber(commonToolService.judgeNull(caseInfo.getCasenumber()));
        } catch (Exception e) {
            log.error("Cabinet.CaseFlowRecord set id或caseid或casenumber出错");
            return null;
        }
        caseFlowRecord.setEpc(commonToolService.judgeNull(caseInfo.getEpc()));
        try {
            caseFlowRecord.setFlowuserid(caseInfo.getOrganiserid());
        } catch (Exception e) {
            log.error("cabinetAlarmService.caseFlowRecord set organiserid 失败");
        }
        caseFlowRecord.setFlowusername(commonToolService.judgeNull(caseInfo.getOrganisername()));
        try {
            caseFlowRecord.setFlowcorpid(caseInfo.getRelegationcorpid());
        } catch (Exception e) {
            log.error("cabinetAlarmService.caseFlowRecord set Relegationcorpid 失败");
        }
        try {
            caseFlowRecord.setFlowcorpname(caseInfo.getRelegationcorpname());
        } catch (Exception e) {
            log.error("cabinetAlarmService.caseFlowRecord set Relegationcorpname 失败");
        }
        caseFlowRecord.setFlowstart(15L);//流转状态
        caseFlowRecord.setFlowconter("应入柜未入柜提醒");
        caseFlowRecord.setState(1L);//0:删除；1:未删除
        caseFlowRecord.setCreatetime(new Date(System.currentTimeMillis()));
        caseFlowRecord.setFlowdate(new Date(System.currentTimeMillis()));
        return caseFlowRecord;
    }

    /**
     *
     * @param lists
     * @param index 1:自离柜时间起24小时
     *               2:自离柜时间起72小时
     *               3:自返还时间起24小时
     *               4:自返还时间起72小时
     */
    public void insertByTurn(List<CaseInfo> lists, int index)
    {
        if(lists!=null && lists.size()>0)
        {
            //***********************插入CaseAlarm表-开始***********************//
            for(CaseInfo caseInfo:lists)
            {
                cabinetTransactionService.insertOneByOne(caseInfo,index);
            }
        }
    }


}
