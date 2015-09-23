package com.onlinejudge.service;

import com.onlinejudge.domain.database.Notice;

/**
 * @author 赵笑天
 *
 * @time 2015年9月17日
 * 
 */
public interface NoticeService {
	public abstract Notice getLastestNotice();
}
