package com.onlinejudge.service;

import java.util.List;

import com.onlinejudge.domain.database.WeeklyScore;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
public interface WeeklyScoreService {
	
	public abstract boolean setAllScoreToZero();
	
	public boolean updateScore(int stuid, double mark);
	
}
