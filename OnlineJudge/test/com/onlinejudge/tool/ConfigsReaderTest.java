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
 * @author ��Ц��
 *
 * @time 2015��9��25��
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
            // ���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�
            // ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
            OutputStream fos = new FileOutputStream(this.getClass().getResource("/").getPath()+"configs.properties");          
            props.setProperty(keyname, keyvalue);
            // ���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��
            // ���� Properties ���е������б�����Ԫ�ضԣ�д�������
            props.store(fos, "Update '" + keyname + "' value");
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
