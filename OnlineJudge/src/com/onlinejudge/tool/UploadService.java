package com.onlinejudge.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ��Ц��
 *
 * @time 2015��9��16��
 * 
 */
public class UploadService {
	
	public String saveUploadFile(String savePath,String imageFileName,File image){
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		try{
			File file = new File(savePath+"/"+imageFileName);
			if (file.exists()){
				file.createNewFile();
			}
			
			fos = new FileOutputStream(file);
			//�����ϴ��ļ���
			fis = new FileInputStream(image);
			
			byte[] buffer = new byte[1024];
			
			int len = 0 ;
			while((len = fis.read(buffer))>0){
				fos.write(buffer);
			}
			
			return savePath+"/"+imageFileName;
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("�ļ��ϴ�ʧ��");
				
		}finally{
			close(fos,fis);
			
		}
		return null;
	}

	
	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("FileInputStream�ر�ʧ��");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("FileOutputStream�ر�ʧ��");
                e.printStackTrace();
            }
        }
	}
}
