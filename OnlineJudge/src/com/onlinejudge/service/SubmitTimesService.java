package com.onlinejudge.service;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
public interface SubmitTimesService {
	//如果没有此条记录，那么创建一个新的记录，初始化赋值后次数减1
	public abstract void subTimes(int stuid, int problemid);
	
	public abstract boolean checkSubmittimes(int stuid,int problemid);

}
