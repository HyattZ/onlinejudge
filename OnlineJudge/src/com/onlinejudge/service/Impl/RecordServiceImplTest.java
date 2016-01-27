package com.onlinejudge.service.Impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.service.RecordService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
public class RecordServiceImplTest {

	/**
	 * Test method for {@link com.onlinejudge.service.Impl.RecordServiceImpl#saveRecord(int, int, java.lang.String)}.
	 */
	@Test
	public void testSaveRecord() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		RecordService recordService = (RecordService) context.getBean("recordServiceImpl");
		recordService.saveRecord(130420105, 1, "flag1");
	}

}
