package com.onlinejudge.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.AdminDao;
import com.onlinejudge.domain.database.Admin;

/**
 * @author 赵笑天
 *
 * @time 2015年10月4日
 * 
 */
@Component("adminDaoImpl")
public class AdminDaoImpl implements AdminDao{
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public Admin getAdminByAdminname(String adminname) {
		Admin admin = (Admin) hibernateTemplate
			.getSessionFactory()
			.getCurrentSession()
			.createQuery("from Admin where adminname = '"+adminname+"'")
			.uniqueResult();
		
		return admin;
	}
	
}
