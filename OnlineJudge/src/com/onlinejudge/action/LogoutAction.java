package com.onlinejudge.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.onlinejudge.constant.Status;

/**
 * @author ��Ц��
 *
 * @time 2015��9��21��
 * 
 */
public class LogoutAction implements ServletRequestAware{
	
	private HttpServletRequest request ;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String logout(){
		//���ｫsession����
		request.getSession().invalidate();
		return Status.SUCCESS;	
	}
}
