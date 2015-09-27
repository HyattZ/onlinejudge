package com.onlinejudge.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.enums.IsLogin;

/**
 * @author 赵笑天
 *
 * @time 2015年9月21日
 * 
 */

@Component("logoutAction")
public class LogoutAction implements ServletRequestAware{
	
	private HttpServletRequest request ;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@AccessToUrl(IsLogin.YES)
	public String logout(){
		//这里将session销毁
		request.getSession().invalidate();
		return Status.SUCCESS;	
	}
}
