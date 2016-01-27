package com.onlinejudge.action;

import java.text.DecimalFormat;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.exception.NoPermissionException;
import com.onlinejudge.service.UserService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
@Component("informationPanelAction")
public class InformationPanelAction implements RequestAware,SessionAware{
	private Map<String ,Object> request;
	private Map<String ,Object> session;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	@AccessToUrl(IsLogin.YES)
	public String getUserInformation(){
		InformationPanelUserInfo ipui = userService.getIPUserInformation((Integer) session.get("stuid"));
		request.put("ipui", ipui);
		String completeness =  getCompleteness(ipui);
		request.put("completeness", completeness);
		return Status.SUCCESS;
	}

	
	private String getCompleteness(InformationPanelUserInfo ipui) {
		int completeNum = 0 ;
		completeNum = ipui.getEmail() != null && !ipui.getEmail().equals("") ? completeNum+1:completeNum;
		completeNum = ipui.getStuid() !=0 ? completeNum+1:completeNum;
		completeNum = ipui.getPhonenum() != null  && ! ipui.getPhonenum().equals("")? completeNum+1:completeNum;
		completeNum = ipui.getQq() !=null  && !ipui.getQq().equals("")? completeNum+1:completeNum;
		completeNum = ipui.getRealname() != null && !ipui.getRealname().equals("")? completeNum+1:completeNum;
		completeNum = ipui.getUsername() != null && !ipui.getUsername().equals("")? completeNum+1:completeNum;
		
		double percent = completeNum*1.0/6.0;
		
		DecimalFormat df = new DecimalFormat("##%");
		return df.format(percent);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
}
