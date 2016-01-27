package com.onlinejudge.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ��Ц��
 *
 * @time 2015��9��30��
 * 
 */
public class ReadPDF {
	public boolean readPDFByProblemid(String fileDirectory, String problemid,
			OutputStream os) throws IOException {
		// �ж��ļ��Ƿ����
		String filePath = fileDirectory + problemid + ".pdf";
		System.out.println(filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		}

		// ����ļ�����
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			os.write(buffer, 0, 1024);
		}

		// �ر��ļ���
		if (fis != null) {
			fis.close();
		}
		return true;
	}
}
