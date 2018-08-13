package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseAlarmMapper;
import com.cetiti.hik.model.CaseAlarm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CaseAlarmService {
    @Autowired
    private CaseAlarmMapper caseAlarmDao;

    public synchronized void  insertCaseAlarm(CaseAlarm caseAlarm)
    {
        caseAlarmDao.insertSelective(caseAlarm);
    }
    public synchronized long getAutoIncreaseId()
    {
        long currentID = caseAlarmDao.autoIncreaseId();
        updateId(currentID+1);
        return currentID;
    }
    public synchronized void updateId(long id)
    {
        caseAlarmDao.updateId(id);
    }

    @Transactional
    public synchronized void insertAndUpdate(CaseAlarm caseAlarm){
        insertCaseAlarm(caseAlarm);
    }

}
