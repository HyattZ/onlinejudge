package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.RecordDao;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
public class RecordDaoImplTest {
	
	@Test
	public void testIsRecordExists() {
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
		RecordDao record = (RecordDao) context.getBean("recordDaoImpl");
		System.out.println(record.isRecordExists("1-130420116"));
	}

}
