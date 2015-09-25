package com.onlinejudge.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Properties;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.mapping.PrimaryKey;

/**
 * @author 赵笑天
 *
 * @time 2015年9月25日
 * 
 */
public class ConfigsOperator {
	
	public String getProperties(String key) throws Exception{
		Properties properties = new Properties();
		File file = new File(this.getClass().getResource("/").getPath()+"/configs.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		properties.load(fileInputStream);
		String value = properties.getProperty(key);
		
		if (fileInputStream != null){
			fileInputStream.close();
		}
		return value;
	}
	
	public void saveProperties(String key,String value) throws IOException{
		Properties properties = new Properties();
/*		File file = new File(this.getClass().getResource("/").getPath()+"/configs.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		properties.load(fileInputStream);
		if (fileInputStream!=null){
			fileInputStream.close();
		}*/
		OutputStream os = new FileOutputStream("F:\\"
				+ "configs.properties");
		properties.setProperty("ssss", "ddsfasdfasf");
		properties.store(os, null);
		
		if (os!=null){
			os.close();
		}
	}
}
