package com.onlinejudge.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.tool.UploadService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */

@Component("uploadAction")
public class UploadAction implements ServletRequestAware{
	private Logger logger = Logger.getLogger(UploadAction.class);
	private HttpServletRequest request;
	//上传文件
	private File image;
	//封装上传文件类型的属性
	private String imageContentType;
	//封装上传文件名的属性
	private String imageFileName;
	//上传文件物理路径
	private String savePath;
	private String result;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
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
	
	/*@AccessToUrl(IsLogin.YES)*/
	public String uploadFile(){
		UploadService us = new UploadService();
		savePath = request.getSession().getServletContext().getRealPath("/")+"WEB-INF\\answers";
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

