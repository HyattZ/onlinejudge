package com.onlinejudge.dao;

import com.onlinejudge.domain.database.Admin;

/**
 * @author 赵笑天
 *
 * @time 2015年10月4日
 * 
 */
public interface AdminDao {

	public abstract Admin getAdminByAdminname(String adminname);
	
}
