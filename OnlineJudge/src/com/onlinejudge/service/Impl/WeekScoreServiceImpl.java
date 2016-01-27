package com.onlinejudge.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.WeekScoreDao;
import com.onlinejudge.domain.database.WeeklyScore;
import com.onlinejudge.service.WeeklyScoreService;

/**
 * @author ��Ц��
 *
 * @time 2015��9��25��
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
	 * �жϼ�¼���Ƿ��м�¼�����û�м�¼����Ѳ����µļ�¼֮����и��²���
	 * 
	 * @return false	��������
	 * 					true		����˳�����
	 * */
	@Override
	public boolean updateScore(int stuid, double mark) {
		WeeklyScore weeklyScore = weeklyScoreDao.getWeeklyScoreById(stuid);
		if (weeklyScore == null){
			//���û�д�����¼
			weeklyScore = new WeeklyScore();
			weeklyScore.setScore(0);
			weeklyScore.setStuid(stuid);
			boolean flag = weeklyScoreDao.saveWeeklyScore(weeklyScore);
			if (!flag){
				//�����������ʧ��
				return false;
			}
		}
		
		weeklyScore.setScore(weeklyScore.getScore()+mark);
		//ִ�и��²���
		weeklyScoreDao.updateScore(weeklyScore);
		return false;
	}

	/*@Override
	public List<WeeklyScore> getScoreList(int length,int beginIndex) {
		return weeklyScoreDao.getScoreList(length,beginIndex);
	}*/
}
