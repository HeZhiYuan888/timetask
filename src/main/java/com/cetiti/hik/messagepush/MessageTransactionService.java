package com.cetiti.hik.messagepush;

import com.cetiti.hik.dao.MessagepushMapper;
import com.cetiti.hik.model.Messagepush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class MessageTransactionService {
    @Autowired
    private MessagepushMapper messagepushDao;

    @Transactional
    public void insertToMessagePush(Messagepush messagepush)
    {
        messagepushDao.insertMessagePush(messagepush);
    }
}
