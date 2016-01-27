package com.onlinejudge.dao;

import java.util.List;

import com.onlinejudge.domain.database.WeeklyScore;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
public interface WeekScoreDao {

	public abstract boolean  updateAllScoreToZero();
	
	public abstract WeeklyScore getWeeklyScoreById(int stuid);

	public abstract boolean saveWeeklyScore(WeeklyScore score);

	public abstract void updateScore(WeeklyScore weeklyScore);


}
