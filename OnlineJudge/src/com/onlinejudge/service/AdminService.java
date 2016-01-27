package com.onlinejudge.service;

import com.onlinejudge.domain.database.Admin;

/**
 * @author 赵笑天
 *
 * @time 2015年10月4日
 * 
 */
public interface AdminService {

	public abstract Admin getAdminByAdminname(String adminname);

}
