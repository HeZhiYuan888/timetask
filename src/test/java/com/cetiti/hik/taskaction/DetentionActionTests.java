package com.cetiti.hik.taskaction;

import com.cetiti.hik.dao.CaseInfoMapper;
import com.cetiti.hik.model.CaseInfo;
import com.cetiti.hik.taskservice.CommonToolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhangshuhua@cetiti.com
 * @date 2018-7-16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DetentionActionTests {

    @Autowired
    DetentionAction detentionAction;
    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CommonToolService commonToolService;



    @Test
    public void testInsertToDetention(){
        detentionAction.insertToDetention();
    }
    @Test
    public void test()
    {
     List<CaseInfo> list0 = caseInfoMapper.getLeftCabinetOverOneDayCaseInfo(true);
     List<CaseInfo> list1 = caseInfoMapper.getLeftCabinetOverOneDayCaseInfo(false);
        System.out.println(list0.size());
        System.out.println(list1.size());
    }

}
