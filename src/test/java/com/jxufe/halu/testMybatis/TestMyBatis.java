package com.jxufe.halu.testMybatis;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.jxufe.halu.psda.mapper.PUserMapper;
import com.jxufe.halu.psda.pojo.PUser;

@RunWith(SpringJUnit4ClassRunner.class)		//��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private PUserMapper pUserMapper = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		PUser user = pUserMapper.selectByPrimaryKey("1");
		// System.out.println(user.getUserName());
		// logger.info("ֵ��"+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
}
