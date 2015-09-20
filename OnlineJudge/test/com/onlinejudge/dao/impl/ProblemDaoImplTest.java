package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.ProblemDao;
import com.onlinejudge.domain.Problem;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
public class ProblemDaoImplTest {

	/**
	 * Test method for {@link com.onlinejudge.dao.impl.ProblemDaoImpl#getProblemList(int, int)}.
	 */
	@Test
	public void testGetProblemList() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ProblemDao pd = (ProblemDao) context.getBean("problemDaoImpl");
		for (Problem p : pd.getProblemList(5, 0)){
			System.out.println(p);
		}
	}
	@Test
	public void testGetFlagById(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ProblemDao pd = (ProblemDao) context.getBean("problemDaoImpl");
		System.out.println(pd.getFlagById(1));
	}
}
