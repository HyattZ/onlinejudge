package com.onlinejudge.service.Impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.SubmitTimesDao;
import com.onlinejudge.service.SubmitTimesService;

/**
 * @author 赵笑天
 *
 * @time 2015年10月7日
 * 
 */
public class SubmitTimesServiceImplTest {

	/**
	 * Test method for {@link com.onlinejudge.service.Impl.SubmitTimesServiceImpl#checkSubmittimes(int, int)}.
	 */
	@Test
	public void testCheckSubmittimes() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SubmitTimesService std = (SubmitTimesService) context.getBean("submitTimesServiceImpl");
		std.checkSubmittimes(130420205, 1);
	}

}
