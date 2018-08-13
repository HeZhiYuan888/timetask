package com.cetiti.hik.dao;

import com.cetiti.hik.model.Casealarmassessscore;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface CasealarmassessscoreMapper extends Mapper<Casealarmassessscore> {
    long autoIncreaseId ();
    void updateId(long id);
}