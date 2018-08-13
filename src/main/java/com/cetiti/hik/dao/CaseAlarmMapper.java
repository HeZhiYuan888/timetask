package com.cetiti.hik.dao;

import com.cetiti.hik.model.CaseAlarm;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CaseAlarmMapper extends Mapper<CaseAlarm> {

    long autoIncreaseId ();
    void updateId(long id);
}