package com.onlinejudge.tool;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Properties;

import org.junit.Test;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
public class ConfigsReaderTest {

	@Test
	public void test() throws Exception {
		ConfigsOperator configsReader = new ConfigsOperator();
		System.out.println(configsReader.getProperties("recordWeek"));
	}
	@Test
	public void test1() throws Exception {
		ConfigsOperator operator = new ConfigsOperator();
		String recordWeek = operator.getProperties("recordWeek");
		Calendar cal = Calendar.getInstance();
		String currentWeek = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.WEEK_OF_YEAR);
		System.out.println(currentWeek+"=========="+recordWeek);
		System.out.println(currentWeek.equals(recordWeek));
		if (!currentWeek.equals(recordWeek)){
			operator.saveProperties("recordWeek",currentWeek);
			System.out.println("false");
			return ;
		}
		System.out.println("true");
		return ;
	}
	

}
