package com.onlinejudge.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ��Ц��
 *
 * @time 2015��9��22��
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
				//����ļ���������ô����Ĭ�ϵ��ļ�
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
