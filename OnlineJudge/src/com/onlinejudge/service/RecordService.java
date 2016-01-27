package com.onlinejudge.service;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
public interface RecordService {

	public abstract boolean isComplete(int stuid, int problemid);
	
	public abstract boolean saveRecord(int stuid, int problemid,String submitflag);

}
