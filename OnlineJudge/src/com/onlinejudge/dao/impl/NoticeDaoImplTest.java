package com.onlinejudge.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinejudge.dao.NoticeDao;

/**
 * @author ��Ц��
 *
 * @time 2015��9��17��
 * 
 */
public class NoticeDaoImplTest {

	/**
	 * Test method for {@link com.onlinejudge.dao.impl.NoticeDaoImpl#getLastestNotice()}.
	 */
	@Test
	public void testGetLastestNotice() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		NoticeDao nd = (NoticeDao) context.getBean("noticeDaoImpl");
		System.out.println(nd.getLastestNotice());
	}

}
