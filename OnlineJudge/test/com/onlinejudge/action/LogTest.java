package com.onlinejudge.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;


/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public class LogTest implements RequestAware{
	private static Logger logger = Logger.getLogger(LogTest.class);
	private Map<String ,Object> request;
	public void test(){
		logger.debug("this is debug");
		logger.info("this is info");
		logger.warn("this is warn");
		logger.error("this is error");
		logger.fatal("this is fatal");
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public void getPaths(){
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println(req.getSession().getServletContext().getContextPath());
	}
}
