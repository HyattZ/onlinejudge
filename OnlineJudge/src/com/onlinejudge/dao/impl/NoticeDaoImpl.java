package com.onlinejudge.dao.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.NoticeDao;
import com.onlinejudge.domain.database.Notice;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Component("noticeDaoImpl")
public class NoticeDaoImpl implements NoticeDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Override
	public Notice getLastestNotice(){
		//选择最大的时间，也就是最新的时间
		Timestamp time = (Timestamp) hibernateTemplate.getSessionFactory().getCurrentSession()
		.createSQLQuery("select max(n.posttime) from Notice n").list().get(0);
		
		Notice notice = (Notice) hibernateTemplate.getSessionFactory().getCurrentSession()
		.createQuery("from Notice n where n.posttime ='"+time+"'").list().get(0);
		
		return notice;
	}

	@Override
	public boolean saveNotice(Notice notice) {
		try{
			hibernateTemplate.save(notice);
			hibernateTemplate.flush();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public List<Notice> getNoticeList(int beginIndex, int length) {
		List<Notice> notices = new ArrayList<Notice>();
		notices = hibernateTemplate.getSessionFactory()
				.getCurrentSession()
				.createQuery("from Notice order by posttime desc")
				.setMaxResults(length)
				.setFirstResult(beginIndex).list();
		if (notices != null && notices.size() > 0){
			return notices;
		}else{
			return null;
		}
	}

	@Override
	public int getNoticeCount() {
		BigInteger count = (BigInteger) hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createSQLQuery("select count(*) from Notice")
				.uniqueResult();
		return count.intValue();
	}
}
