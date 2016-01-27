package com.onlinejudge.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import javax.annotation.Resource;

import org.apache.struts2.views.xslt.SimpleAdapterDocument;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.dao.SubmitTimesDao;
import com.onlinejudge.domain.database.SubmitTime;
import com.onlinejudge.service.SubmitTimesService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
@Component("submitTimesServiceImpl")
public class SubmitTimesServiceImpl implements SubmitTimesService {
	private SubmitTimesDao submitTimesDao;
	private RecordDao recordDao;

	public RecordDao getRecordDao() {
		return recordDao;
	}

	@Resource(name = "recordDaoImpl")
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public SubmitTimesDao getSubmitTimesDao() {
		return submitTimesDao;
	}

	@Resource(name = "submitTimesDaoImpl")
	public void setSubmitTimesDao(SubmitTimesDao submitTimesDao) {
		this.submitTimesDao = submitTimesDao;
	}

	@Override
	public void subTimes(int stuid, int problemid) {
		if (submitTimesDao.isRecordExist(stuid, problemid)) {
			// 如果submittimes的记录存在
			submitTimesDao.subTimes(stuid, problemid);
		} else {
			// 如果不存在那么创建一条新的记录，并对其次数进行减1操作
			submitTimesDao.addRecord(stuid, problemid);
			submitTimesDao.subTimes(stuid, problemid);
		}
	}

	@Override
	public boolean checkSubmittimes(int stuid, int problemid) {

		try {
			int times = submitTimesDao.getTimes(stuid, problemid);
			Date date = submitTimesDao.getRecordDate(stuid, problemid);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = sdf.format(new Date());
			Date currentDate = sdf.parse(dateString);
			if (date.before(currentDate)) {
				// 如果数据库里面的日期比当前日期小
				submitTimesDao.updateSubmitTimes(stuid, problemid);			
				return true;
			} else {
				if (times > 0 && times <= 20) {
					return true;
				}
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		} 
	}
}
