package com.cetiti.hik.dao;


import com.cetiti.hik.model.CaseBorrowed;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CaseBorrowedMapper extends Mapper<CaseBorrowed> {

    List<CaseBorrowed> getCaseBorrowOverOneDay(@Param("beforeSetTime") boolean beforeSetTime);

    List<CaseBorrowed> getCaseBorrowOverThreeDay(@Param("beforeSetTime") boolean beforeSetTime);

    void insertTest(CaseBorrowed borrowed);

}