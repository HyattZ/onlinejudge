package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.dto.LoginFormBean;
import com.onlinejudge.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public class LoginAction implements  ServletRequestAware,SessionAware,ModelDriven{
	private Logger logger = Logger.getLogger(LoginAction.class);
	private HttpServletRequest request;
	private Map<String,Object> session;
	private LoginFormBean lfb;
	private UserService userService;



	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override
	public Object getModel() {
		return lfb;
	}
	
	public LoginFormBean getLfb() {
		return lfb;
	}
	@Resource(name="loginFormBean")
	public void setLfb(LoginFormBean lfb) {
		this.lfb = lfb;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String checkLogin(){
		/**
		 * 
		 * 功能：验证账号密码验证码登录
		 * 
		 * */
		System.out.println(session.get("authcode"));
		if (!lfb.validateAuthCode((String)session.get("authcode"))){
			
			session.put("errorReason", "验证码错误！");
			return Status.AUTHCODEERROR;
		}
		
		if (!lfb.validateUserName()){
			session.put("errorReason", "用户名非法！");
		}
		
		if (!lfb.validatePassword(userService.getPasswordByUserName(lfb.getUsername()))){
			session.put("errorReason", "密码错误！");
			return Status.PASSWORDERROR;
		}
		User u = userService.getUserByUsername(lfb.getUsername());
		session.put("isLogin", true);
		session.put("stuid", u.getStuid());
		return Status.SUCCESS;
	}
	
}
