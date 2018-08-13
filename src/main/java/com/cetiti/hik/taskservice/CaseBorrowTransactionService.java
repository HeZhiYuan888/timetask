package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseAlarmPersonMapper;
import com.cetiti.hik.dao.CaseBorrowedMapper;
import com.cetiti.hik.dao.CaseEarlyWarningMapper;
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
public class CaseBorrowTransactionService
{
    private static Logger log = LoggerFactory.getLogger(CaseBorrowTransactionService.class);

    @Autowired
    private CaseAlarmService caseAlarmService;

    @Autowired
    private CaseAlarmPersonService caseAlarmPersonService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CaseFlowRecordService caseFlowRecordService;

    @Autowired
    private CaseBorrowedService caseBorrowedService;

    /**
     * 一次事务插入三张表，同时插入或者同时回滚
     * @param caseBorrowed
     * @param is24Hour
     */
    @Transactional
    public void insertOneByOne(CaseBorrowed caseBorrowed, boolean is24Hour){
        CaseAlarm caseAlarm = null;
        CaseAlarmPerson caseAlarmPerson = null;
        CaseFlowRecord caseFlowRecord = null;
        CaseInfo caseInfo = null;
        try {
            caseInfo = caseBorrowedService.getCaseInfoByCaseNumber(caseBorrowed.getCasenumber());
            //***********************插入CaseAlarm表-开始***********************//
            caseAlarm = caseBorrowedService.getOverDateCaseAlarm(caseBorrowed, is24Hour);
            if(caseAlarm!=null)
            {
                caseAlarmService.insertAndUpdate(caseAlarm);//插入后更新sequence 中caseAlarm表中id
            }
        } catch (Exception e) {
            log.error("CaseBorrowedService.caseAlarmService.insertAndUpdate出错",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        //*********************插入CaseAlarm表-结束*********************//

        //***********************插入CaseAlarmPerson表-开始***********************//
        if(caseAlarm!=null)
        {
            try {
                caseAlarmPerson = caseBorrowedService.getOverDateCaseAlarmPerson(caseBorrowed, caseAlarm, caseInfo, new UserInfo(), is24Hour, false);
                caseAlarmPersonService.insertAndUpdate(caseAlarmPerson);//插入后更新caseAlarmPerson中caseAlarm表中id
            } catch (Exception e) {
                log.error("CaseBorrowService.caseAlarmPersonService.insertAndUpdate出错",e);
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
                log.error("CaseBorrowService.userInfoService.getManager出错",e);
            }
            if (userInfos != null && userInfos.size() > 0)
            {
                for (UserInfo userInfo : userInfos)
                {
                    CaseAlarmPerson caseAlarmManager = caseBorrowedService.getOverDateCaseAlarmPerson(caseBorrowed, caseAlarm, caseInfo, userInfo, is24Hour, true);
                    if(caseAlarmPerson!=null)
                    {
                        try {
                            caseAlarmPersonService.insertAndUpdate(caseAlarmManager);//插入后更新caseAlarmPerson中caseAlarm表中id
                        } catch (Exception e) {
                            log.error("CaseBorrowService.caseAlarmPersonService.insertAndUpdate出错",e);
                            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            continue;
                        }
                    }
                }
            }
        }

        //***********************插入CaseAlarmPerson表-开始***********************//

        //***********************插入CaseFlowRecord表-开始***********************//
        if(caseAlarm!=null)
        {
            try {
                caseFlowRecord = caseBorrowedService.getOverDateCaseFlowRecord(caseBorrowed);
                if(caseFlowRecord!=null)
                {
                    caseFlowRecordService.insertAndUpdate(caseFlowRecord);//插入后更新caseFlowRecord中caseAlarm表中id
                }
            } catch (Exception e) {
                log.error("CaseBorrowedService.caseFlowRecordService.insertAndUpdate出错",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }

        //************************插入CaseFlowRecord表-结束********************
    }
}
