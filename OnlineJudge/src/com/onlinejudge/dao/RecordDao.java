package com.onlinejudge.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.onlinejudge.domain.database.Record;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public interface RecordDao {

	public abstract boolean isRecordExists(String recordid);
	
	public abstract void saveRecord(Record record);
	
}
