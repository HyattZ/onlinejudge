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
		updateProperties("hehehe", "hahahha");
	}
	
	public void updateProperties(String keyname,String keyvalue) {
		Properties props = new Properties();
		System.out.println(this.getClass().getResource("/").getPath()+"configs.properties");
        try {
            props.load(new FileInputStream(this.getClass().getResource("/").getPath()+"configs.properties"));
           System.out.println( props.get("hehehe"));
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(this.getClass().getResource("/").getPath()+"configs.properties");          
            props.setProperty(keyname, keyvalue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "Update '" + keyname + "' value");
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
