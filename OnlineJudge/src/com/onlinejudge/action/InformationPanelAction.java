package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.service.UserService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
public class InformationPanelAction implements RequestAware{
	private Map<String ,Object> request;
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
	
	public String getUserInformation(){
		InformationPanelUserInfo ipui = userService.getIPUserInformation(130420206);
		System.out.println(ipui);
		request.put("ipui", ipui);
		return Status.SUCCESS;
	}
}
