package com.onlinejudge.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 赵笑天
 *
 * @time 2015年9月30日
 * 
 */
public class ReadPDF {
	public boolean readPDFByProblemid(String fileDirectory, String problemid,
			OutputStream os) throws IOException {
		// 判断文件是否存在
		String filePath = fileDirectory + problemid + ".pdf";
		System.out.println(filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		}

		// 如果文件存在
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			os.write(buffer, 0, 1024);
		}

		// 关闭文件流
		if (fis != null) {
			fis.close();
		}
		return true;
	}
}
