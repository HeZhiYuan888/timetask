package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseAlarmPersonMapper;
import com.cetiti.hik.model.CaseAlarmPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CaseAlarmPersonService {
    @Autowired
    private CaseAlarmPersonMapper caseAlarmPersonDao;
    public synchronized void insertCaseAlarmPerson(CaseAlarmPerson caseAlarmPerson)
    {
        caseAlarmPersonDao.insertSelective(caseAlarmPerson);
    }
    public synchronized long getAutoIncreaseId()
    {
        long currentID = caseAlarmPersonDao.autoIncreaseId();
        updateId(currentID);
        return currentID;
    }
    public synchronized void updateId(long id)
    {
        caseAlarmPersonDao.updateId(id);
    }

    @Transactional
    public synchronized void insertAndUpdate(CaseAlarmPerson caseAlarmPerson){
//      updateId(caseAlarmPerson.getId());
        insertCaseAlarmPerson(caseAlarmPerson);
    }

}
