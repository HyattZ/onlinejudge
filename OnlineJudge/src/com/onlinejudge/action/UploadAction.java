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
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
public class UploadAction {
	private Logger logger = Logger.getLogger(UploadAction.class);
	//上传文件
	private File image;
	//封装上传文件类型的属性
	private String imageContentType;
	//封装上传文件名的属性
	private String imageFileName;
	//上传文件物理路径
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

