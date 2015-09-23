package com.onlinejudge.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.ProblemDao;
import com.onlinejudge.domain.SubmitPageProblemInfo;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.dto.ResultFormBean;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
@Component("problemDaoImpl")
public class ProblemDaoImpl implements ProblemDao{
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public List<Problem> getProblemList(int length, int beginIndex) {
		List<Problem> problems = new ArrayList<Problem>();
		problems = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery("from Problem p")
				.setMaxResults(length)
				.setFirstResult(beginIndex).list();
		hibernateTemplate.flush();
		return problems;
	}
	
	public String getFlagById(int id){
		List flags =  hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createSQLQuery("select p.flag from Problem p where p.problemid="+id)
				.list();
		if (flags == null || flags.isEmpty()){
			return null;
		}else{
			return (String) flags.get(0);
		}
		
	}
	
	@Override
	public long getProblemCount() {
		BigInteger count = (BigInteger) hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery("select count(*) from Problem")
				.list().get(0);
		return count.longValue() ;
	}


	@Override
	public SubmitPageProblemInfo getSFPProblem(int id) {
		List list = hibernateTemplate.getSessionFactory()
										.openSession()
										.createSQLQuery("select problemid,problemtitle from Problem where problemid="+id)
										.list();
		if (list == null || list.size() ==0){
			return null;
		}else{
			Object[] obj = (Object[]) list.get(0);
			SubmitPageProblemInfo sfp = new SubmitPageProblemInfo((Integer)obj[0],(String)obj[1]);
			return sfp;
		}
	}
}
