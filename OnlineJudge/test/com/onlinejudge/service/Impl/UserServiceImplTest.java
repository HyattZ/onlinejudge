package com.onlinejudge.service.Impl;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;



import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.UserDao;
import com.onlinejudge.domain.User;
import com.onlinejudge.service.UserService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public class UserServiceImplTest {

	/**
	 * Test method for {@link com.onlinejudge.service.Impl.UserServiceImpl#getUserMap(int, int)}.
	 */
	@Test
	public void testGetUserMap() {
		ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService) ca.getBean("userServiceImpl");
		System.out.println(us.getUserMap(5, 0).size());
		Map<String, User> users = us.getUserMap(5, 0);
		Set<String> keys = users.keySet();
		for (String i:keys){
			System.out.println(i+"==="+users.get(i));
		}
		JSONObject json =  JSONObject.fromObject(users);
		String result = json.toString();
		System.out.println(result);
		
	}
	@Test
	public void testGetPasswordByUserName(){
		ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService) ca.getBean("userServiceImpl");
		System.out.println(us.getPasswordByUserName("zxt01"));
	}
}
