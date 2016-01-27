package com.onlinejudge.service.Impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.domain.database.Record;
import com.onlinejudge.service.RecordService;

/**
 * @author ��Ц��
 *
 * @time 2015��9��26��
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
	 * @return true		��Ŀ�Ѿ����
	 * 					false	��Ŀ��δ���
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
