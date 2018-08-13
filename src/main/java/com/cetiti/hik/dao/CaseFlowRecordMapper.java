package com.cetiti.hik.dao;


import com.cetiti.hik.model.CaseFlowRecord;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CaseFlowRecordMapper extends Mapper<CaseFlowRecord> {

    long autoIncreaseId();

    void updateId(long id);
}