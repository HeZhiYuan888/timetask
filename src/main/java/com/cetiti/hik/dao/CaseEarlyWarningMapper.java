package com.cetiti.hik.dao;

import com.cetiti.hik.model.CaseEarlyWarning;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CaseEarlyWarningMapper  extends Mapper<CaseEarlyWarning> {

    long getCaseEarlyWarningID(@Param("type") int type, @Param("dictionarytype") int dictionarytype);

    String getDecideResults(long type);
}