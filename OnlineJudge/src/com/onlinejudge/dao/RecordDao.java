package com.onlinejudge.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.onlinejudge.domain.database.Record;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */
public interface RecordDao {

	public abstract boolean isRecordExists(String recordid);
	
	public abstract void saveRecord(Record record);
	
}
