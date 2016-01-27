package com.onlinejudge.dao;

import java.util.List;

import com.onlinejudge.domain.database.Notice;

/**
 * @author 赵笑天
 *
 * @time 2015年9月17日
 * 
 */
public interface NoticeDao {

	public abstract Notice getLastestNotice();

	public abstract boolean saveNotice(Notice notice);

	public abstract List<Notice> getNoticeList(int beginIndex, int length);
	
	public abstract int getNoticeCount();

}