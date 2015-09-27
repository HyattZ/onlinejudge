package com.onlinejudge.action;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.enums.IsLogin;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ��Ц��
 *
 * @time 2015��9��22��
 * 
 */

@Component("getFaviconAction")
public class GetFaviconAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String stuid;
	
	public String getStuid() {
		return stuid;
	}
	
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	
	@AccessToUrl(IsLogin.YES)
	public String getFavicon(){
		return Status.SUCCESS;
	}
}
