package com.onlinejudge.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.SubmitTimesDao;
import com.onlinejudge.domain.database.SubmitTime;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
@Component("submitTimesDaoImpl")
public class SubmitTimesDaoImpl implements SubmitTimesDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean isRecordExist(int stuid, int problemid) {
		List list = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from SubmitTime where stuid=" + stuid
								+ " and problemid=" + problemid).list();
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void subTimes(int stuid, int problemid) {
		SubmitTime submitTime = getSubmitTime(stuid, problemid);
		submitTime.setSubmittimes(submitTime.getSubmittimes()-1);
		hibernateTemplate.update(submitTime);
		hibernateTemplate.flush();
	}

	@Override
	public void addRecord(int stuid, int problemid) {
		
		try {
			SubmitTime submitTime = new SubmitTime();
			submitTime.setProblemid(problemid);
			submitTime.setStuid(stuid);
			submitTime.setSubmittimesid(problemid+"-"+stuid);
			submitTime.setRecorddate(getTimeStamp());
			submitTime.setSubmittimes(20);
			hibernateTemplate.save(submitTime);
			hibernateTemplate.flush();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	private SubmitTime getSubmitTime(int stuid, int problemid) {
		List list = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from SubmitTime where stuid=" + stuid
								+ " and problemid=" + problemid).list();
		if (list != null && list.size() > 0) {
			return (SubmitTime) list.get(0);
		} else {
			return null;
		}
	}
	
	private Timestamp getTimeStamp() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		String dateString = sdf.format(new Date());
		return new Timestamp((sdf.parse(dateString)).getTime());
	}


	@Override
	public int getTimes(int stuid, int problemid) {
		SubmitTime submitTime = getSubmitTime(stuid, problemid);
		if (submitTime != null){
			//System.out.println(submitTime.getSubmittimes());
			return submitTime.getSubmittimes();
		}else{
			addRecord(stuid, problemid);
			return 20;
		}
	}

	@Override
	public Date getRecordDate(int stuid, int problemid){
		SubmitTime submitTime = getSubmitTime(stuid, problemid);
		if (submitTime != null){
			return submitTime.getRecorddate();
		}else{
			addRecord(stuid, problemid);
			submitTime = getSubmitTime(stuid, problemid);
			return submitTime.getRecorddate();
		}
	}
	
	/**
	 * 
	 * 功能，将数据的日期改为当前日期，同时将剩余次数设置为20
	 * 
	 * */
	@Override
	public void updateSubmitTimes(int stuid, int problemid) {
		try {
			SubmitTime submitTime = getSubmitTime(stuid, problemid);
			submitTime.setRecorddate(getTimeStamp());
			submitTime.setSubmittimes(20);
			hibernateTemplate.update(submitTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
