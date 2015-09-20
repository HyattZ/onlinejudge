package com.onlinejudge.tool;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
public class MD5Test {

	/**
	 * Test method for {@link com.onlinejudge.tool.MD5#GetMD5Code(java.lang.String)}.
	 */
	@Test
	public void testGetMD5Code() {
		System.out.println(MD5.GetMD5Code("ehe").length());
	}

}
