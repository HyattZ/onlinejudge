package com.onlinejudge.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.onlinejudge.constant.Status;
import com.onlinejudge.tool.UploadService;

/**
 * @author ��Ц��
 *
 * @time 2015��9��16��
 * 
 */
public class UploadAction {
	private Logger logger = Logger.getLogger(UploadAction.class);
	//�ϴ��ļ�
	private File image;
	//��װ�ϴ��ļ����͵�����
	private String imageContentType;
	//��װ�ϴ��ļ���������
	private String imageFileName;
	//�ϴ��ļ�����·��
	private String savePath;
	
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public String uploadFile(){
		UploadService us = new UploadService();
		String uri = us.saveUploadFile(savePath, imageFileName, image);
		System.out.println(uri);
		Map<String,String> map = new HashMap<String,String>();
		map.put("faviconuri", uri);
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
		setResult(json.toString());
		return Status.SUCCESS;
	}

}

