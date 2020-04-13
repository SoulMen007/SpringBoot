package com.pwc.workbench.util;

import com.alibaba.fastjson.JSON;
import com.pwc.workbench.domain.User;
import com.pwc.workbench.util.RedisUtil;

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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RedisUtilTest extends TestCase {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtilTest.class);

    @Resource
    RedisUtil redisUtil;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void del() {
    }

    @Test
    public void get() {

    }

    @Test
    public void set() {
        User user = new User();
        user.setId(1L);
        user.setUserName("Jack Xie");
        user.setPassword("123456");
        user.setEmail("jack.x.xie@pwc.com");
        logger.debug(JSON.toJSONString(user));
        redisUtil.set("user", JSON.toJSONString(user));
        logger.debug("user: " + redisUtil.get("user"));;
    }

}