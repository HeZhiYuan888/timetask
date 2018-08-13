package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseFlowRecordMapper;
import com.cetiti.hik.model.CaseFlowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CaseFlowRecordService {
    @Autowired

    private CaseFlowRecordMapper caseFlowRecordDao;

    public synchronized void insertCaseFlowRecord(CaseFlowRecord caseFlowRecord) {
        caseFlowRecordDao.insertSelective(caseFlowRecord);
    }

    public synchronized long getAutoIncreaseId() {
        long currentID = caseFlowRecordDao.autoIncreaseId();
        updateId(currentID);
        return currentID;
    }

    public synchronized void updateId(long id) {
        caseFlowRecordDao.updateId(id);
    }


    public synchronized void insertAndUpdate(CaseFlowRecord caseFlowRecord){
//        updateId(caseFlowRecord.getId());
        insertCaseFlowRecord(caseFlowRecord);
    }

}

