package com.onlinejudge.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.NoticeDao;
import com.onlinejudge.domain.database.Notice;
import com.onlinejudge.service.NoticeService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月17日
 * 
 */
@Component("noticeServiceImpl")
public class NoticeServiceImpl implements NoticeService{
	private NoticeDao noticeDao;

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}
	@Resource(name="noticeDaoImpl")
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public Notice getLastestNotice() {
		return noticeDao.getLastestNotice();
	}

}
