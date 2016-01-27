package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.ProblemDao;
import com.onlinejudge.domain.database.Problem;

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
	
	@Test
	public void testSubmitPageProblemInfo(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ProblemDao pd = (ProblemDao) context.getBean("problemDaoImpl");
		System.out.println(pd.getSFPProblem(1));
	}
	
	@Test
	public void testGetProblemByProblemid(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ProblemDao pd = (ProblemDao) context.getBean("problemDaoImpl");
		System.out.println(pd.getProblemByProblemid(1));
	}
	
	@Test
	public void testGetWeekNum(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ProblemDao pd = (ProblemDao) context.getBean("problemDaoImpl");
		System.out.println(pd.getWeekNum());
	}
	
	@Test
	public void testGetProblmeIdsByWeek(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ProblemDao pd = (ProblemDao) context.getBean("problemDaoImpl");

	}
	
	@Test
	public void testGetProblemIdsByRound(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ProblemDao pd = (ProblemDao) context.getBean("problemDaoImpl");
		for (Integer integer:pd.getProblemIdsByRound(1)){
			System.out.println(integer.intValue());
		}
	}
}
