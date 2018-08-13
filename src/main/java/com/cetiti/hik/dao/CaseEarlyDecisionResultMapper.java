package com.cetiti.hik.dao;


import com.cetiti.hik.model.CaseEarlyDecisionResult;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CaseEarlyDecisionResultMapper  extends Mapper<CaseEarlyDecisionResult> {

    CaseEarlyDecisionResult selectByPrimaryKey(Long id);

    String getDecisionResult(long caseearlywarningid);
}