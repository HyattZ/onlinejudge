package com.onlinejudge.service;

/**
 * @author ��Ц��
 *
 * @time 2015��9��26��
 * 
 */
public interface RecordService {

	public abstract boolean isComplete(int stuid, int problemid);
	
	public abstract boolean saveRecord(int stuid, int problemid,String submitflag);

}
