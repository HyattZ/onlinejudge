package com.onlinejudge.action;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public class LogTestTest {

	/**
	 * Test method for {@link com.onlinejudge.action.LogTest#test()}.
	 */
	@Test
	public void testTest() {
		LogTest lt  = new LogTest();
		lt.test();
	}

	@Test
	public void testGetPaths(){
		LogTest lt  = new LogTest();
		lt.getPaths();
	}
}
