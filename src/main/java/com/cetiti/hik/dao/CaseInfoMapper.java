package com.cetiti.hik.dao;


import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.model.Casealarmassessscore;
import com.cetiti.hik.paramVO.CaseAlarmAssessScoreVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CaseInfoMapper extends Mapper<CaseInfo> {

    public CaseInfo getCaseInfo(String casenumber);

    public void updateId(long id);

    public long autoIncreaseId();
    public List<CaseInfo> test();


    //自离柜时间起24小时
    public List<CaseInfo> getLeftCabinetOverOneDayCaseInfo(@Param("beforeSetTime") boolean beforeSetTime);
    //自返还时间起24小时
    public List<CaseInfo> getReturnOverOneDayCaseInfo(@Param("beforeSetTime") boolean beforeSetTime);
    //自离柜时间起72小时
    public List<CaseInfo> getLeftCabinetOverThreeDaysCaseInfo(@Param("beforeSetTime") boolean beforeSetTime);
    //自返还时间起72小时
    public List<CaseInfo> getReturnOverThreeDaysCaseInfo(@Param("beforeSetTime") boolean beforeSetTime);

    //未贴标签
    public List<CaseInfo> getNoTagOver24Hour(@Param("beforeSetTime") boolean beforeSetTime);


//    自立案起，30天
    public List<CaseInfo> casePass30Days(@Param("days") int days, @Param("isFirstTime") boolean isFirst,@Param("beforeSetTime") boolean beforeSetTime);
//    自立案起，60天
    public List<CaseInfo> casePass60Days(@Param("days") int days, @Param("isFirstTime") boolean isFirst,@Param("beforeSetTime") boolean beforeSetTime);
    //久放未动 受立案且有嫌疑人
    public List<CaseInfo> longTimeNoMoveHasSuspect(@Param("beforeSetTime") boolean beforeSetTime);
    //受立案且嫌疑人已刑事拘留
    public List<CaseInfo> longTimeNoMoveCustodyed(@Param("beforeSetTime") boolean beforeSetTime);
    //受立案且无嫌疑人  行政六个月
    public List<CaseInfo> longTimeNoMoveNoSuspect6(@Param("months")int months,@Param("beforeSetTime") boolean beforeSetTime);
    //受立案且无嫌疑人  刑事12个月
    public List<CaseInfo> longTimeNoMoveNoSuspect12(@Param("months")int months,@Param("beforeSetTime") boolean beforeSetTime);

    //待归档-结案起，满一年提醒
    public List<CaseInfo> getTobeArchivedFullYear(@Param("beforeSetTime") boolean beforeSetTime);
    //移送起诉-移送起诉起始，7日提醒
    public List<CaseInfo> getTobeArchivedProsecution(@Param("beforeSetTime") boolean beforeSetTime);
    //未办结且无线索-受立案起，6个月未动，最后一天提醒
    public List<CaseInfo> getTobeArchivedNoMove6Month(@Param("beforeSetTime") boolean beforeSetTime);
    //未办结且无线索-受立案起，12个月未动，最后一天提醒
    public List<CaseInfo> getTobeArchivedNoMove12Month(@Param("beforeSetTime") boolean beforeSetTime);

    //自刑拘起7天第7天提醒
    public List<CaseInfo> detention7Days( @Param("list1") List list1,@Param("beforeSetTime") boolean beforeSetTime);
    //自刑拘起7天第7天下午提醒
    public List<CaseInfo> detention7DayAfternoon(@Param("list1") List list1,@Param("beforeSetTime") boolean beforeSetTime);
    //自刑拘起30天（延长）,第20天提醒一次，第28天，29天，30天各提醒一次
    public List<CaseInfo> detention30Days( @Param("days") int days ,@Param("list1") List list1,@Param("list2") List list2,@Param("isFirstTime") boolean isFirstTime,@Param("beforeSetTime") boolean beforeSetTime);

    //自取保候审起一年 满月查询
    public List<CaseInfo> getBailByMonth(@Param("months") int months,@Param("list1") List list1,@Param("beforeSetTime") boolean beforeSetTime);
    //嫌疑人已取保候审x天
    public List<CaseInfo> getBailByDay(@Param("days") int days,@Param("list1") List list1,@Param("beforeSetTime") boolean beforeSetTime);

    //监视居住到期 到期前10天提醒一次，到期前3天每天提醒一次
    public List<CaseInfo> getSupervisionByDay( @Param("days") int days,@Param("list1") List list1,@Param("beforeSetTime") boolean beforeSetTime);

    //移诉提醒
    public List<CaseInfo> getLawsuitByMonth(@Param("months") int months,@Param("list1") List list1,@Param("beforeSetTime") boolean beforeSetTime);
    public List<CaseInfo> getLawsuitByDay(@Param("days") int days,@Param("list1") List list1,@Param("beforeSetTime") boolean beforeSetTime);

    //整改到期提醒,整改期到期前 days 天提醒一次,目前为2
    public List<CaseInfo> rectification(@Param("days") int days,@Param("beforeSetTime") boolean beforeSetTime);
/////////////////////////////////////////开始扣分////////////////////////////////////////////
    public List<CaseAlarmAssessScoreVO> getCaseAlarmAssessScoreVOByType(int alarmtype);

    public List<CaseAlarmAssessScoreVO> getDetention7DayScore(@Param("list1") List list1);

    public List<CaseAlarmAssessScoreVO> getDetention30DayScore(@Param("list1") List list1,@Param("list2") List list2 );

    public List<CaseAlarmAssessScoreVO> getBailScoreScore(@Param("list1") List list1);
    public List<CaseAlarmAssessScoreVO> getSupervisionScore(@Param("list1") List list1);
    public List<CaseAlarmAssessScoreVO> getLawsuitScore(@Param("list1") List list1);
    public List<CaseAlarmAssessScoreVO> getRectificationScore();
    public List<CaseAlarmAssessScoreVO> getCasePass30dayScore();
    public List<CaseAlarmAssessScoreVO> getCasePass60dayScore();


}