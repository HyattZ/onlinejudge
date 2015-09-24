package com.onlinejudge.action;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

/**
 * @author 赵笑天
 *
 * @time 2015年9月20日
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
	
	@Test
	public void testDateCompare() throws ParseException{
		
		/*System.out.println(date.compareTo(new Date()));*/

		String dateString = "2015-09-25";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		Date d = sdf.parse(dateString);
		String currentDateString = sdf.format(new Date());
		Date cd = sdf.parse(currentDateString);
		System.out.println(cd.compareTo(d));
		
	}
}
