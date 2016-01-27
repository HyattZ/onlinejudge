package com.onlinejudge.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.onlinejudge.domain.database.Score;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */
public interface ScoreDao {

	public abstract Score getScoreByStuid(int intValue);

	public abstract void updateScore(Score score, double d);

	public abstract void save(Score score);
	
}
