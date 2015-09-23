package com.onlinejudge.dao;

import com.onlinejudge.domain.database.Notice;

/**
 * @author 赵笑天
 *
 * @time 2015年9月17日
 * 
 */
public interface NoticeDao {

	public abstract Notice getLastestNotice();

}