package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.ProblemDao;
import com.onlinejudge.domain.database.Problem;

/**
 * @author ��Ц��
 *
 * @time 2015��9��16��
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
}
