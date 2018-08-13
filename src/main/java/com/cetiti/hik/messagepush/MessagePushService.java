package com.cetiti.hik.messagepush;

import com.cetiti.hik.dao.MessagepushMapper;
import com.cetiti.hik.model.Messagepush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessagePushService {
    private static Logger log = LoggerFactory.getLogger(MessagePushService.class);

    @Autowired
    private MessageTransactionService messageTransactionService;

    @Autowired
    private MessagepushMapper messagepushDao;

    public List<Messagepush> getNoSignMessagePush()
    {
        List<Messagepush> messagepushList = null;
        try {
            messagepushList = messagepushDao.getMessagePush(0);
        } catch (Exception e) {
           log.error("MessagePushService.getNoSignMessagePush出错",e);
        }
        return messagepushList;
    }
    public List<Messagepush> getNoFeedbackMessagePush()
    {
        List<Messagepush> messagepushList = null;
        try {
            messagepushList = messagepushDao.getMessagePush(1);
        } catch (Exception e) {
           log.error("MessagePushService.getNoFeedbackMessagePush出错",e);
        }
        return messagepushList;
    }

    public  String modifyContent(String alarmContent,long days,int type)
    {
        StringBuffer sb = new StringBuffer("");
        if(alarmContent!=null && !alarmContent.isEmpty())
        {
            String[] strs =  alarmContent.split("，|,");
            String[] newStrs = new String[strs.length+1];
            System.arraycopy(strs,0,newStrs,0,strs.length-1);
            if(type==0)
            {
                newStrs[newStrs.length-2] = "您已经"+days+"天未签收";
            }
            else if(type==1)
            {
                newStrs[newStrs.length-2] = "您已经"+days+"天未反馈";
            }
            newStrs[newStrs.length-1] = strs[strs.length-1];
            for(int i=0, l = newStrs.length;i<l;i++)
            {
                if(i <l-1)
                {
                    sb.append(newStrs[i]+"，");
                }
                else
                {
                    sb.append(newStrs[i]);
                }
            }
        }
        return sb.toString();
    }


    public void insertNoSignMessageOneByOne(Messagepush messagepush)
    {
            if(messagepush.getContent()!=null && !messagepush.getContent().isEmpty()&& messagepush.getDays()==0)
            {
                messagepush.setAlarmcontent(messagepush.getContent());
            }
            else if(messagepush.getContent()!=null && !messagepush.getContent().isEmpty() && messagepush.getDays()>0)
            {
                String content = modifyContent(messagepush.getContent(),messagepush.getDays(),0);
                messagepush.setAlarmcontent(content);
            }
             messagepush.setCreatetime(new Date(System.currentTimeMillis()));
             messageTransactionService.insertToMessagePush(messagepush);


    }
    public void insertNoFeedbackMessageOneByOne(Messagepush messagepush)
    {
            if(messagepush.getContent()!=null && !messagepush.getContent().isEmpty()&& messagepush.getDays()==0)
            {
                messagepush.setAlarmcontent(messagepush.getContent());
            }
            else if(messagepush.getContent()!=null && !messagepush.getContent().isEmpty() && messagepush.getDays()>0)
            {
                String content = modifyContent(messagepush.getContent(),messagepush.getDays(),1);
                messagepush.setAlarmcontent(content);
            }
            messagepush.setCreatetime(new Date(System.currentTimeMillis()));
            messageTransactionService.insertToMessagePush(messagepush);

    }
    public void insertNoSignMessage()
    {
        List<Messagepush> list = new ArrayList<Messagepush>();
        list = getNoSignMessagePush();
        if(list!=null && list.size()>0)
        {
            for(Messagepush messagepush:list)
            {
                if(messagepush.getPolicecode()!=null&&messagepush.getCasenumber()!=null&&messagepush.getCaseid()!=null&&messagepush.getCasealarmpersonid()!=null&&messagepush.getDealauthority()!=null)
                {
                    insertNoSignMessageOneByOne(messagepush);
                }
            }
        }
    }
    public void insertNoFeedbackMessage()
    {
        List<Messagepush> list = new ArrayList<Messagepush>();
        list = getNoFeedbackMessagePush();
        if(list!=null && list.size()>0)
        {
            for(Messagepush messagepush:list)
            {
                if(messagepush.getPolicecode()!=null&&messagepush.getCasenumber()!=null&&messagepush.getCaseid()!=null&&messagepush.getCasealarmpersonid()!=null&&messagepush.getDealauthority()!=null)
                {
                    insertNoFeedbackMessageOneByOne(messagepush);
                }
            }
        }
    }

}
