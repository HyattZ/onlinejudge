package com.onlinejudge.dao;

import java.util.List;

import com.onlinejudge.domain.database.Notice;

/**
 * @author ��Ц��
 *
 * @time 2015��9��17��
 * 
 */
public interface NoticeDao {

	public abstract Notice getLastestNotice();

	public abstract boolean saveNotice(Notice notice);

	public abstract List<Notice> getNoticeList(int beginIndex, int length);
	
	public abstract int getNoticeCount();

}