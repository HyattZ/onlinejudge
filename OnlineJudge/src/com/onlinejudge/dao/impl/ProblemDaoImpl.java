package com.onlinejudge.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.HierarchicalBeanFactory;
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
										.getCurrentSession()
										.createSQLQuery("select problemid,problemtitle,problemcontent from Problem where problemid="+id)
										.list();
		if (list == null || list.size() ==0){
			return null;
		}else{
			Object[] obj = (Object[]) list.get(0);
			SubmitPageProblemInfo sfp = new SubmitPageProblemInfo((Integer)obj[0],(String)obj[1],(String)obj[2]);
			return sfp;
		}
	}


	@Override
	public Problem getProblemByProblemid(int problemid) {
		Problem problem = (Problem) hibernateTemplate.getSessionFactory()
			.getCurrentSession()
			.get(com.onlinejudge.domain.database.Problem.class, problemid);
		
		return problem;
	}

	@Override
	public boolean saveProblem(Problem problem) {
		try{
			hibernateTemplate.save(problem);
			hibernateTemplate.flush();
			return true;
		}catch(Exception e){
			return false;
		}
	}


	@Override
	public List<Problem> getProblmeIdsByWeek(int week) {
		List<Problem> problems = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery("from Problem where round = "+week)
				.list();
		
		if (problems != null && problems.size() > 0){
			return problems;
		}
		return null;
	}

	@Override
	public int getWeekNum() {
		int weekTotalNum = 0;
		weekTotalNum = (Integer) hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createSQLQuery("select max(round) from Problem")
				.uniqueResult();
		return weekTotalNum;
	}


	@Override
	public List<Problem> getProblemListByRound(int currentRound) {
		List<Problem> problems = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery("from Problem where round="+currentRound)
				.list();
		if (problems != null && problems.size() > 0){
			return problems;
		}else{
			return null;
		}
	}

	@Override
	public List<Integer> getProblemIdsByRound(int currentRound) {
		List<Integer> problemIds = hibernateTemplate.getSessionFactory()
				.getCurrentSession()
				.createSQLQuery("select problemid from Problem where round="+currentRound)
				.list();
		if (problemIds != null && problemIds.size() > 0){
			return problemIds;
		}else{
			return null;
		}
	}
}
