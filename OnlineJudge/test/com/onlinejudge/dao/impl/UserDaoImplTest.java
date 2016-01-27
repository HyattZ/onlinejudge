package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.UserDao;
import com.onlinejudge.domain.database.User;

/**
 * @author 赵笑天
 *
 * @time 2015年9月24日
 * 
 */
public class UserDaoImplTest {

	/**
	 * Test method for {@link com.onlinejudge.dao.impl.UserDaoImpl#isStuIdAvailable(int)}.
	 */
	@Test
	public void testIsStuIdAvailable() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao ud = (UserDao) context.getBean("userDaoImpl");
		System.out.println(ud.isEmailAvailable("393504144@qq.com"));
	}
	
	@Test
	public void testGetUserRankList(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao ud = (UserDao) context.getBean("userDaoImpl");
		System.out.println(ud.getUserRankList(5, 0).size());
	}
	
	@Test
	public void testGetUserWeeklyScoreList(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao ud = (UserDao) context.getBean("userDaoImpl");
		for (User u : ud.getUserWeeklyScoreList(5, 0)){
			System.out.println(u);
		}
	}
	
	@Test
	public void testGetUserCount(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao ud = (UserDao) context.getBean("userDaoImpl");
		System.out.println(ud.getUserScoreCount());
		System.out.println(ud.getUseWeeklyrScoreCount());
	}
}
