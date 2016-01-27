package com.onlinejudge.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.WeekScoreDao;
import com.onlinejudge.domain.database.WeeklyScore;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
@Component("weeklyScoreDaoImpl")
public class WeeklyScoreDaoImpl implements WeekScoreDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean updateAllScoreToZero() {
		try{
			hibernateTemplate.getSessionFactory()
				.getCurrentSession()
				.createSQLQuery("update WeeklyScore set score=0")
				.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public WeeklyScore getWeeklyScoreById(int stuid) {
		return (WeeklyScore) hibernateTemplate.get(WeeklyScore.class, stuid);
	}
	
	@Override
	public boolean saveWeeklyScore(WeeklyScore score) {
		try{
			hibernateTemplate.save(score);
			hibernateTemplate.flush();
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public void updateScore(WeeklyScore weeklyScore) {
		hibernateTemplate.update(weeklyScore);
		hibernateTemplate.flush();
	}

	/*@Override
	public List<WeeklyScore> getScoreList(int length, int beginIndex) {
		List<WeeklyScore> weeklyScores = (List<WeeklyScore>) hibernateTemplate
										.getSessionFactory()
										.getCurrentSession()
										.createQuery("from WeeklyScore order by score")
										.setFirstResult(beginIndex)
										.setMaxResults(length)
										.list();
		
		if (weeklyScores != null && weeklyScores.size() >0){
			return weeklyScores;
		}else{
			return null;
		}
	}*/
	
}
