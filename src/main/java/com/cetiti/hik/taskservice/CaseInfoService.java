package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.CaseInfoMapper;
import com.cetiti.hik.model.CaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseInfoService {
    @Autowired
    private CaseInfoMapper caseInfoDao;

    public CaseInfo getCaseInfo(String casenumber) {
        return caseInfoDao.getCaseInfo(casenumber);
    }

    public synchronized void updateId(long id) {
        caseInfoDao.updateId(id);
    }

    public synchronized  long autoIncreaseId() {
        return caseInfoDao.autoIncreaseId();
    }


}
