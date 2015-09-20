package com.onlinejudge.action;

import java.io.IOException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.onlinejudge.constant.Status;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public class AuthCodeAction extends ActionSupport{

	private static final long serialVersionUID = -427219907570705189L;
	private String zxt;
	
	
	public String getAuthCode(){
		return Status.SUCCESS;
	}


	public String getZxt() {
		return zxt;
	}


	public void setZxt(String zxt) {
		this.zxt = zxt;
	}



}
