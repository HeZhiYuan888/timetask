package com.cetiti.hik.messagepush;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessagepushAction {
    @Autowired
    private MessagePushService messagePushService;
    @Scheduled(cron = "${messagepushtask1}")
    public void insertNoSignMessage()
    {
        messagePushService.insertNoSignMessage();
    }
    @Scheduled(cron = "${messagepushtask2}")
    public void insertNoFeedbakMessage()
    {
        messagePushService.insertNoFeedbackMessage();
    }
}
