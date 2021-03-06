package com.cetiti.hik.taskservice;

import com.cetiti.hik.model.*;
import com.cetiti.hik.paramVO.UserInfoParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
@Service
public class ToBeArchivedTransactionService {

    private static Logger log = LoggerFactory.getLogger(ToBeArchivedTransactionService.class);

    @Autowired
    private CaseAlarmService caseAlarmService;

    @Autowired
    private CaseAlarmPersonService caseAlarmPersonService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CaseFlowRecordService caseFlowRecordService;


    @Autowired
    private ToBeArchivedService toBeArchivedService;


    /**
     * 一次事务插入三张表，同时插入或者同时回滚
     * @param caseInfo
     */
    @Transactional
    public void insertOneByOne(CaseInfo caseInfo, int index )
    {
        //立案提醒
        CaseAlarm caseAlarm = toBeArchivedService.getNearDaysExpiresCaseAlarm(caseInfo, index);
        try {
            if(caseAlarm!=null)
            {
                caseAlarmService.insertAndUpdate(caseAlarm);//插入后更新sequence 中caseAlarm表中id
            }
        } catch (Exception e) {
            log.error("ToBeArchivedService.caseAlarmService.insertAndUpdate出错",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        //插入alarmPerson
        if(caseAlarm!=null)
        {
            CaseAlarmPerson caseAlarmPerson = null;
            caseAlarmPerson = toBeArchivedService.getOverDateCaseAlarmPerson(caseAlarm, caseInfo, new UserInfo(), index, false);
            try {
                if(caseAlarmPerson!=null)
                {
                    caseAlarmPersonService.insertAndUpdate(caseAlarmPerson);//插入后更新caseAlarmPerson中caseAlarm表中id
                }
            } catch (Exception e) {
                log.error("ToBeArchivedService.caseAlarmPersonService.insertAndUpdate出错",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }

            UserInfoParam userInfoParam = new UserInfoParam();
            userInfoParam.setUsertype(1);
            userInfoParam.setCorpid(caseInfo.getCorpid());
            //查询符合案件单位的所有管理员，向他们推送数据
            List<UserInfo> userInfos = null;
            try {
                userInfos = userInfoService.getManager(userInfoParam);
            } catch (Exception e) {
                log.error("ToBeArchivedService.userInfoService.getManager出错",e);
            }
            if (userInfos != null && userInfos.size() > 0) {
                for (UserInfo userInfo : userInfos) {
                    try {
                        CaseAlarmPerson caseAlarmManager = toBeArchivedService.getOverDateCaseAlarmPerson(caseAlarm, caseInfo, userInfo, index, true);
                        if(caseAlarmManager!=null)
                        {
                            caseAlarmPersonService.insertAndUpdate(caseAlarmManager);//插入后更新caseAlarmPerson中caseAlarm表中id
                        }
                    } catch (Exception e) {
                        log.error("ToBeArchivedService.caseAlarmPersonService.insertAndUpdate出错",e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        continue;
                    }
                }
            }
        }

        //插入CaseFlowRecord表
        if(caseAlarm!=null)
        {
            try {
                CaseFlowRecord caseFlowRecord = toBeArchivedService.getCaseFlowRecord(caseInfo);
                if(caseFlowRecord!=null)
                {
                    caseFlowRecordService.insertAndUpdate(caseFlowRecord);//插入后更新caseFlowRecord中caseAlarm表中id
                }
            } catch (Exception e) {
                log.error("ToBeArchivedService.caseFlowRecordService.insertAndUpdate出错",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
    }
}
