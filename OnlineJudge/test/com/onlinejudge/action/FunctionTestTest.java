package com.onlinejudge.action;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ��Ц��
 *
 * @time 2015��9��20��
 * 
 */
public class FunctionTestTest {

	/**
	 * Test method for {@link com.onlinejudge.action.FunctionTest#FunctionTest(long)}.
	 */
	@Test
	public void testFunctionTest() {
		FunctionTest ft = new FunctionTest(1);
		for (long i = 1;i < 26 ;i++){
			long[] values = ft.getIndexs(i, 3);
			System.out.println(values[0]+"---"+values[1]);
			System.out.println("======================");
		}
	}

}
