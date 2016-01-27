package com.onlinejudge.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.AdminDao;
import com.onlinejudge.domain.database.Admin;
import com.onlinejudge.service.AdminService;

/**
 * @author 赵笑天
 *
 * @time 2015年10月4日
 * 
 */
@Component("adminServiceImpl")
public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource(name="adminDaoImpl")
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin getAdminByAdminname(String adminname) {
		
		return getAdminDao().getAdminByAdminname(adminname);
	}
	
}
