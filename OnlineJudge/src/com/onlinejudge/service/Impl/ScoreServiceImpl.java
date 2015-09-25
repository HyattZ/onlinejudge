package com.onlinejudge.service.Impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.ScoreDao;
import com.onlinejudge.domain.database.Score;
import com.onlinejudge.service.ProblemService;
import com.onlinejudge.service.ScoreService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月24日
 * 
 */
@Component("scoreServiceImpl")
public class ScoreServiceImpl implements ScoreService{
	private ScoreDao scoreDao;
	private HibernateTemplate hibernateTemplate;

	public ScoreDao getScoreDao() {
		return scoreDao;
	}
	@Resource(name="scoreDaoImpl")
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean updateScore(Integer stuid,double mark) {
		try{
			Score score = scoreDao.getScoreByStuid(stuid.intValue());
			scoreDao.updateScore(score,score.getScore()+mark);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
}
