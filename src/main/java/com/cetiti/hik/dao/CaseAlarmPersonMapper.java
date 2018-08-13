package com.cetiti.hik.dao;

import com.cetiti.hik.model.CaseAlarmPerson;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface CaseAlarmPersonMapper extends Mapper<CaseAlarmPerson> {
    long autoIncreaseId();

    void updateId(long id);
}