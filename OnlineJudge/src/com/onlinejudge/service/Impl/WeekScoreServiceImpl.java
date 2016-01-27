package com.onlinejudge.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.WeekScoreDao;
import com.onlinejudge.domain.database.WeeklyScore;
import com.onlinejudge.service.WeeklyScoreService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
@Component("weeklyScoreServiceImpl")
public class WeekScoreServiceImpl implements WeeklyScoreService{
	private WeekScoreDao weeklyScoreDao;

	public WeekScoreDao getWeeklyScoreDao() {
		return weeklyScoreDao;
	}
	@Resource(name="weeklyScoreDaoImpl")
	public void setWeeklyScoreDao(WeekScoreDao weeklyScoreDao) {
		this.weeklyScoreDao = weeklyScoreDao;
	}

	@Override
	public boolean setAllScoreToZero() {
		return weeklyScoreDao.updateAllScoreToZero();
	}
	
	/**
	 * 
	 * 判断记录中是否有记录，如果没有记录，则把插入新的记录之后进行更新操作
	 * 
	 * @return false	操作出错
	 * 					true		操作顺利完成
	 * */
	@Override
	public boolean updateScore(int stuid, double mark) {
		WeeklyScore weeklyScore = weeklyScoreDao.getWeeklyScoreById(stuid);
		if (weeklyScore == null){
			//如果没有此条记录
			weeklyScore = new WeeklyScore();
			weeklyScore.setScore(0);
			weeklyScore.setStuid(stuid);
			boolean flag = weeklyScoreDao.saveWeeklyScore(weeklyScore);
			if (!flag){
				//如果插入数据失败
				return false;
			}
		}
		
		weeklyScore.setScore(weeklyScore.getScore()+mark);
		//执行更新操作
		weeklyScoreDao.updateScore(weeklyScore);
		return false;
	}

	/*@Override
	public List<WeeklyScore> getScoreList(int length,int beginIndex) {
		return weeklyScoreDao.getScoreList(length,beginIndex);
	}*/
}
