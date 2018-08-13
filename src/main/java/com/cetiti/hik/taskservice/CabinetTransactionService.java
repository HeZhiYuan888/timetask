package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.*;
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
public class CabinetTransactionService {
    private static Logger log = LoggerFactory.getLogger(CabinetTransactionService.class);


    @Autowired
    private CaseAlarmService caseAlarmService;

    @Autowired
    private CaseAlarmPersonService caseAlarmPersonService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CaseFlowRecordService caseFlowRecordService;

    @Autowired
    private CabinetAlarmService cabinetAlarmService;

    /**
     * 一次事务插入三张表，同时插入或者同时回滚
     * @param caseInfo
     * @param index
     */
    @Transactional
    public void insertOneByOne(CaseInfo caseInfo, int index)
    {
        CaseAlarm caseAlarm = null;
        try {
            caseAlarm = cabinetAlarmService.getOverOneDayCaseAlarm(caseInfo,index);
            if(caseAlarm!=null)
            {
                caseAlarmService.insertAndUpdate(caseAlarm);//插入后更新sequence 中caseAlarm表中id
            }
        } catch (Exception e) {
            log.error("CabinetAlarmService.caseAlarmService.insertAndUpdate出错",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        //*********************插入CaseAlarm表-结束*********************//

        //***********************插入CaseAlarmPerson表-开始***********************//

        if(caseAlarm!=null)
        {
            CaseAlarmPerson caseAlarmPerson = null;
            try {
                caseAlarmPerson = cabinetAlarmService.getOverDateCaseAlarmPerson(caseAlarm,caseInfo,new UserInfo(),index,false);
                //这里肯定不是null
                caseAlarmPersonService.insertAndUpdate(caseAlarmPerson);//插入后更新caseAlarmPerson中caseAlarm表中id
            } catch (Exception e) {
                log.error("CabinetAlarmService.caseAlarmPersonService.insertAndUpdate出错",e);
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
                log.error("CabinetAlarmService.userInfoService.getManager出错",e);
            }
            if(userInfos !=null && userInfos.size()>0)
            {
                for(UserInfo userInfo :userInfos)
                {
                    try {
                        CaseAlarmPerson caseAlarmManager = cabinetAlarmService.getOverDateCaseAlarmPerson(caseAlarm,caseInfo,userInfo,index,true);
                        if(caseAlarmManager!=null)
                        {
                            caseAlarmPersonService.insertAndUpdate(caseAlarmManager);//插入后更新caseAlarmPerson中caseAlarm表中id
                        }
                    } catch (Exception e) {
                        log.error("CabinetAlarmService.caseAlarmPersonService.insertAndUpdate出错",e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        continue;
                    }
                }
            }
        }

        //***********************插入CaseAlarmPerson表-结束***********************//
        //***********************插入CaseFlowRecord表-开始***********************//
        if(caseAlarm!=null)
        {
            try {
                CaseFlowRecord caseFlowRecord = cabinetAlarmService.getCaseFlowRecord(caseInfo);
                if(caseFlowRecord!=null)
                {
                    caseFlowRecordService.insertAndUpdate(caseFlowRecord);//插入后更新caseFlowRecord中caseAlarm表中id
                }
            } catch (Exception e) {
                log.error("CabinetAlarmService.FlowRecordService.insertAndUpdate出错",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }

        //************************插入CaseFlowRecord表-结束**********************
    }
}
