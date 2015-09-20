package com.onlinejudge.action;

import org.apache.log4j.Logger;


/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
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
