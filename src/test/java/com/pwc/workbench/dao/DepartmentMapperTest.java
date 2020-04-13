package com.pwc.workbench.dao;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pwc.workbench.dao.DepartmentMapper;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DepartmentMapperTest extends TestCase {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentMapperTest.class);

    @Autowired
    private DepartmentMapper departmentMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNameToIdMap() {
        Map<String, Map<String, Object>> map = departmentMapper.getNameToIdMap();
        logger.debug(map.toString());
        TestCase.assertEquals(8L, map.get("PM").get("id"));
    }
}