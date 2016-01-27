package com.onlinejudge.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.PermissionCheck;
import com.onlinejudge.constant.Status;
import com.onlinejudge.constant.ThreadLocalSession;
import com.onlinejudge.enums.Permission;

/**
 * @author 赵笑天
 *
 * @time 2015年9月28日
 * 
 */
@Component
public class TestUploadAction implements ServletRequestAware,
		ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;


	private List<File> docs;// 这里的"fileName"一定要与表单中的文件域名相同
	private List<String> docsContentType;// 格式同上"fileName"+ContentType
	private List<String> Filename;// 格式同上"fileName"+FileName
	private List<String> docsFileName;
	private List<String> folder;
	private List<String> Upload;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;
	}
	
	
	public String upload() throws IOException {
			//获取到存储的位置,如果没有则创建一个新的文件夹
			String savePath = request.getSession().getServletContext()
					.getRealPath("");
			savePath += "WEB-INF\\answers\\";
			savePath = URLDecoder.decode(savePath,"UTF-8");
			File file1 = new File(savePath);
			if (!file1.exists()) {
				file1.mkdirs();
			}
			
			for (int i = 0 ;i < docs.size();i++){
				File desFile = new File(savePath+Filename.get(i));
				FileOutputStream fos = new FileOutputStream(desFile);
				FileInputStream fis = new FileInputStream(docs.get(i));
				byte[] buf = new byte[1024];
				int len = 0;
				while ((len = fis.read(buf))>0){
					fos.write(buf, 0, 1024);
				}
			
				if (fis != null){
					fis.close();
				}
				if (fos != null){
					fos.close();
				}
			}
			
			return Status.SUCCESS;
	}

	public List<File> getDocs() {
		return docs;
	}

	public void setDocs(List<File> docs) {
		this.docs = docs;
	}

	public List<String> getDocsContentType() {
		return docsContentType;
	}

	public void setDocsContentType(List<String> docsContentType) {
		this.docsContentType = docsContentType;
	}

	public List<String> getFilename() {
		return Filename;
	}

	public void setFilename(List<String> filename) {
		Filename = filename;
	}

	public List<String> getDocsFileName() {
		return docsFileName;
	}

	public void setDocsFileName(List<String> docsFileName) {
		this.docsFileName = docsFileName;
	}

	public List<String> getFolder() {
		return folder;
	}

	public void setFolder(List<String> folder) {
		this.folder = folder;
	}

	public List<String> getUpload() {
		return Upload;
	}

	public void setUpload(List<String> upload) {
		Upload = upload;
	}


}
