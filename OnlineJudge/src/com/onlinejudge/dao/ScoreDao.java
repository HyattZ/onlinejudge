package com.onlinejudge.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.onlinejudge.domain.database.Score;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public interface ScoreDao {

	public abstract Score getScoreByStuid(int intValue);

	public abstract void updateScore(Score score, double d);

	public abstract void save(Score score);
	
}
