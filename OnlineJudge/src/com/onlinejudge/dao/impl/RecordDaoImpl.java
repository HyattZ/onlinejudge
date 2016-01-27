package com.onlinejudge.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.domain.database.Record;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
@Component("recordDaoImpl")
public class RecordDaoImpl implements RecordDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public boolean isRecordExists(String recordid) {
		Record record = (Record) hibernateTemplate.get(Record.class, recordid);
		if (record != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void saveRecord(Record record) {
		hibernateTemplate.save(record);
		hibernateTemplate.flush();
	}
	
}
