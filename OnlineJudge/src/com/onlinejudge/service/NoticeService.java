package com.onlinejudge.service;

import java.util.Collection;
import java.util.List;

import com.onlinejudge.domain.NoticeInfo;
import com.onlinejudge.domain.database.Notice;
import com.onlinejudge.dto.NoticeFormBean;

/**
 * @author ��Ц��
 *
 * @time 2015��9��17��
 * 
 */
public interface NoticeService {
	public abstract NoticeInfo getLastestNotice();
	
	public abstract boolean addNotice(NoticeFormBean noticeFormBean);
	
	public abstract List<NoticeInfo> getNoticeList(int beginIndex, int length);
	
	public abstract int getNoticeCount();
}
