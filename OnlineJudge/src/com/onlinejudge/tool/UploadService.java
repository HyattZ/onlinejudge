package com.onlinejudge.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
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
			//建立上传文件流
			fis = new FileInputStream(image);
			
			byte[] buffer = new byte[1024];
			
			int len = 0 ;
			while((len = fis.read(buffer))>0){
				fos.write(buffer);
			}
			
			return savePath+"/"+imageFileName;
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("文件上传失败");
				
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
                System.out.println("FileInputStream关闭失败");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("FileOutputStream关闭失败");
                e.printStackTrace();
            }
        }
	}
}
