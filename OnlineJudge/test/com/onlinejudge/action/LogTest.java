package com.onlinejudge.action;

import org.apache.log4j.Logger;


/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public class LogTest {
	private static Logger logger = Logger.getLogger(LogTest.class);
	
	public void test(){
		logger.debug("this is debug");
		logger.info("this is info");
		logger.warn("this is warn");
		logger.error("this is error");
		logger.fatal("this is fatal");
	}
}
