package com.onlinejudge.service;

import java.util.List;

import com.onlinejudge.domain.database.WeeklyScore;

/**
 * @author ��Ц��
 *
 * @time 2015��9��25��
 * 
 */
public interface WeeklyScoreService {
	
	public abstract boolean setAllScoreToZero();
	
	public boolean updateScore(int stuid, double mark);
	
}
