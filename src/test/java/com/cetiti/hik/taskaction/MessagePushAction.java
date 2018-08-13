package com.cetiti.hik.taskaction;

import com.cetiti.hik.messagepush.MessagepushAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessagePushAction {
    @Autowired
    private MessagepushAction messagepushAction;
    @Test
    public void insertNoSignMessage()
    {
        messagepushAction.insertNoSignMessage();
    }
}
