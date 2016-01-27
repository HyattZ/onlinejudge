package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.SubmitTimesDao;

/**
 * @author ��Ц��
 *
 * @time 2015��9��25��
 * 
 */
public class SubmitTimesDaoImplTest {
	
	@Test
	public void testIsRecordExist() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SubmitTimesDao std = (SubmitTimesDao) context.getBean("submitTimesDaoImpl");
		System.out.println(std.isRecordExist(130420205, 1));
	}

	/**
	 * Test method for {@link com.onlinejudge.dao.impl.SubmitTimesDaoImpl#subTimes(int, int)}.
	 */
	@Test
	public void testSubTimes() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SubmitTimesDao std = (SubmitTimesDao) context.getBean("submitTimesDaoImpl");
		std.subTimes(130420105, 1);
	}
	
	@Test
	public void testAddRecord() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SubmitTimesDao std = (SubmitTimesDao) context.getBean("submitTimesDaoImpl");
		std.addRecord(130420206, 1);
	}
	
}
