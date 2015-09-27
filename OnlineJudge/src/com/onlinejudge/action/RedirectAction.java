package com.onlinejudge.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.constant.Status;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */

@Component("redirectAction")
public class RedirectAction implements SessionAware,RequestAware{
	private Map<String,Object> session;
	private Map<String,Object> request;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	/**
	 * 
	 * ���ܣ���session�еĴ���ԭ���ó������Ƴ���session�����õ�
	 * 				request��ҳ�����
	 * 
	 * */
	public String TransErrorMessage(){
		Object errorReason = session.get("errorReason");
		Object errorPageTitle = session.get("errorPageTitle");
		
		if (errorReason == null ){
			request.put("errorReason", "��������");
		}
		
		if (errorPageTitle == null){
			request.put("errorPageTitle", "����");
		}
		
		if (errorPageTitle != null && errorReason != null){
			request.put("errorReason", errorReason);
			request.put("errorPageTitle",errorPageTitle);
		}
		
		return Status.SUCCESS;
	}
	
	public String TransSuccessMessage(){
		
		request.put("successMessage", session.get("successMessage"));
		request.put("successPageTitle", session.get("successPageTitle"));
		
		session.remove("successMessage");
		session.remove("successPageTitle");
		return Status.SUCCESS;
	}
}
