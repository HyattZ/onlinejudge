package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.WeekScoreDao;
import com.onlinejudge.domain.database.WeeklyScore;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
public class WeeklyScoreDaoImplTest {

	/**
	 * Test method for {@link com.onlinejudge.dao.impl.WeeklyScoreDaoImpl#updateAllScoreToZero()}.
	 */
	@Test
	public void testUpdateAllScoreToZero() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		WeekScoreDao wsd = (WeekScoreDao) context.getBean("weeklyScoreDaoImpl");
		System.out.println(wsd.updateAllScoreToZero());
	}

	/*@Test
	public void testGetScoreList(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		WeekScoreDao wsd = (WeekScoreDao) context.getBean("weeklyScoreDaoImpl");
		System.out.println(wsd.getScoreList(2, 0).get(0));
		
	}*/
}
