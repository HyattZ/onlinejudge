package com.onlinejudge.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.onlinejudge.constant.Status;

/**
 * @author 赵笑天
 *
 * @time 2015年9月21日
 * 
 */
public class LogoutAction implements ServletRequestAware{
	
	private HttpServletRequest request ;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String logout(){
		//这里将session销毁
		request.getSession().invalidate();
		return Status.SUCCESS;	
	}
}
