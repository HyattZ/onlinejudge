package com.onlinejudge.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.ScoreDao;
import com.onlinejudge.domain.database.Score;

/**
 * @author 赵笑天
 *
 * @time 2015年9月24日
 * 
 */
@Component("scoreDaoImpl")
public class ScoreDaoImpl implements ScoreDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public Score getScoreByStuid(int stuid) {
		Score score = (Score) hibernateTemplate.get(com.onlinejudge.domain.database.Score.class, stuid);
		hibernateTemplate.flush();
		return score;
	}


	@Override
	public void updateScore(Score score, double d) {
		score.setScore(d);
		hibernateTemplate.update(score);
		hibernateTemplate.flush();
	}

	@Override
	public void save(Score score) {
		hibernateTemplate.save(score);
		hibernateTemplate.flush();	
	}



}
