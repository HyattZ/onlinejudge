package com.onlinejudge.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public class ScoreDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
