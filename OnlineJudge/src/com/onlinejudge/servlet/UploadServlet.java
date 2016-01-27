package com.onlinejudge.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.onlinejudge.constant.Status;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath = request.getSession().getServletContext().getRealPath("");
		savePath += "/answers/";
		File file1 =new File(savePath);
		if (!file1.exists()){
			file1.mkdirs();
		}
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("UTF-8");
		List fileList = null;
		
		try{
			fileList = upload.parseRequest(request);
		}catch(Exception e){
			return ;
		}
		
		Iterator<FileItem> it = fileList.iterator();
		String name = "";
		String extName = "";
		
		while(it.hasNext()){
			FileItem item= it.next();
			name = item.getName();
			long size = item.getSize();
			String type = item.getContentType();
			System.out.println(size+"-"+type);
			
			if (name == null || name.trim().equals("")){
				continue;
			}
			
			if (name.lastIndexOf(',') >= 0){
				extName = name.substring(name.lastIndexOf(','));
			}
			
			File file = null;
			do{
				name = UUID.randomUUID().toString();
				file = new File(savePath+name+extName);
			}while(file.exists());
			File saveFile = new File(savePath+name+extName);
			
			try{
					item.write(saveFile);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
		
	}

}
