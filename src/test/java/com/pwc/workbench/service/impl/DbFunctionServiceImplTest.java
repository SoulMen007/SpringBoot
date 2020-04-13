package com.pwc.workbench.service.impl;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DbFunctionServiceImplTest extends TestCase {

    private static final Logger logger = LoggerFactory.getLogger(DbFunctionServiceImplTest.class);

    @Resource
//    private DbFunctionService dbFunctionService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void updateFinalActualData() {
        //Map<String, Object> paramMap = new HashMap<>();
       // Long managementId = 463L;
        Long[] managementId = {899L,901L,903L,905L,907L,909L,911L,913L,915L,917L,919L,921L};
       for(int i=0;i<managementId.length;i++) {
    	   Map<String, Object> paramMap = new HashMap<>();
    	   paramMap.put("p_from_mng_id", managementId[i]);
//           dbFunctionService.updateFinalActualData(paramMap);
           if (paramMap.get("x_err_code").equals("S")) {
               logger.debug("DB function [updateFinalActualData] return Success result.");
           } else {
               logger.debug("DB function [updateFinalActualData] return Error result.");
               logger.debug(paramMap.get("x_err_code") + ": " + paramMap.get("x_err_msg"));
           }
       }
        
        

    }
}