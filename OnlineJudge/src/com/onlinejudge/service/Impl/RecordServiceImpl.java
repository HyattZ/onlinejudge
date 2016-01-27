package com.onlinejudge.service.Impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.domain.database.Record;
import com.onlinejudge.service.RecordService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
@Component("recordServiceImpl")
public class RecordServiceImpl implements RecordService{
	private RecordDao recordDao;

	public RecordDao getRecordDao() {
		return recordDao;
	}
	@Resource(name="recordDaoImpl")
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	/**
	 * 
	 * @return true		题目已经完成
	 * 					false	题目还未完成
	 * */
	@Override
	public boolean isComplete(int stuid, int problemid) {
		return recordDao.isRecordExists(problemid+"-"+stuid);
	}

	@Override
	public boolean saveRecord(int stuid, int problemid,String submitflag) {
		try{
			Record record = new Record();
			record.setProblemid(problemid);
			record.setRecordid(problemid+"-"+stuid);
			record.setStuid(stuid);
			record.setSubmitflag(submitflag);
			Date date = new Date();
			record.setSubmittime(new Timestamp(date.getTime()));
			recordDao.saveRecord(record);
			return true;
		}catch(Exception e){
			return false;
		}
	}


}
