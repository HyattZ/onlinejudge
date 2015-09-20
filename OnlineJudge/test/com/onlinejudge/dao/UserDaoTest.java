package com.onlinejudge.dao;

import static org.junit.Assert.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.domain.User;


/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */
public class UserDaoTest {

	/**
	 * Test method for {@link com.onlinejudge.dao.impl.UserDaoImpl#getUserList(int, int)}.
	 */
	@Test
	public void testGetUserList() {
		ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ca.getBean("userDaoImpl");
		
		for (User u : userDao.getUserRankList(5,1)){
			System.out.println(u.getScore());
		}
		
		
	}

}
