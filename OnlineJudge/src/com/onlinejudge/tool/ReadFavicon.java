package com.onlinejudge.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
public class ReadFavicon {

	private String filename;

	public ReadFavicon(String filename) {
		this.filename = filename;
	}

	public boolean outputFavicon(OutputStream os) throws IOException {
		if (filename == null || filename.equals("")) {
			return false;
		} else {
				File file = new File(filename);
				//如果文件不存在那么返回默认的文件
				if (!file.exists()){
					filename = filename.replaceAll("\\d{9}", "default");
					file = new File(filename);
				}
				
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				while ((fis.read(buffer, 0, 1024)) != -1) {
					os.write(buffer, 0, 1024);
				}
				if (fis != null) {
					fis.close();
				}
				return true;
		}
	}
}
