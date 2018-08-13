package com.cetiti.hik.taskservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.util.resources.ar.CalendarData_ar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@Service
public class CommonToolService {
    private static Logger log = LoggerFactory.getLogger(CommonToolService.class);
    public String dateToStr(Date date)
    {
        String str = "无";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
        if(date!=null)
        {
            try {
                str = sdf.format(date);
            } catch (Exception e) {
                log.error("CommonToolService.dateToStr Date日期转换错误");
                return str;
            }
        }
        return str;

    }
    public  String judgeNull(String string)
    {
        String str = string;
        if (string==null || string.isEmpty())
        {
            str = "无";
        }
        return str;
    }
    public boolean beforeSetTime()
    {
        boolean flag = true;
        Calendar calendar = Calendar.getInstance();
        long nows = calendar.getTimeInMillis();
        calendar.set(2018,8,1,0,0,0);
        long setTimes = calendar.getTimeInMillis();
        if(nows-setTimes < 0)
        {
            flag = true;
        }
        else if(nows-setTimes > 0)
        {
            flag = false;
        }
        return flag;
    }










}
