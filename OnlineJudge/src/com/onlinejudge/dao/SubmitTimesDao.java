package com.onlinejudge.dao;

import java.util.Date;

/**
 * @author ��Ц��
 *
 * @time 2015��9��25��
 * 
 */
public interface SubmitTimesDao {

	public abstract boolean isRecordExist(int stuid, int problemid);
	
	public abstract void subTimes(int stuid, int problemid);

	public abstract void addRecord(int stuid, int problemid);

	public abstract int getTimes(int stuid, int problemid);
	
	public abstract Date getRecordDate(int stuid, int problemid);
	
	public abstract void updateSubmitTimes(int stuid, int problemid);
	
}
