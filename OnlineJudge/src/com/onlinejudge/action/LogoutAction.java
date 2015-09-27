package com.onlinejudge.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.enums.IsLogin;

/**
 * @author ��Ц��
 *
 * @time 2015��9��21��
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
		//���ｫsession����
		request.getSession().invalidate();
		return Status.SUCCESS;	
	}
}
