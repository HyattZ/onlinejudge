package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.RecordDao;

/**
 * @author ��Ц��
 *
 * @time 2015��9��26��
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
