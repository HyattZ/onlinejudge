package com.onlinejudge.tool;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ��Ц��
 *
 * @time 2015��9��16��
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
