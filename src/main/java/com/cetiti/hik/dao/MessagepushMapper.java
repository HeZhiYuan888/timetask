package com.cetiti.hik.dao;

import com.cetiti.hik.model.Messagepush;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MessagepushMapper extends Mapper<Messagepush> {
    public void insertMessagePush(Messagepush messagepush);

    /**
     *
     * @param type 0:未签收 1：未反馈
     * @return
     */
    public List<Messagepush> getMessagePush(int type);
}