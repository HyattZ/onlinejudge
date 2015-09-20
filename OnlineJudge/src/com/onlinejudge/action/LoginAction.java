package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.dto.LoginFormBean;
import com.onlinejudge.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
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
		 * ���ܣ���֤�˺�������֤���¼
		 * 
		 * */
		System.out.println(session.get("authcode"));
		if (!lfb.validateAuthCode((String)session.get("authcode"))){
			
			session.put("errorReason", "��֤�����");
			return Status.AUTHCODEERROR;
		}
		
		if (!lfb.validateUserName()){
			session.put("errorReason", "�û����Ƿ���");
		}
		
		if (!lfb.validatePassword(userService.getPasswordByUserName(lfb.getUsername()))){
			session.put("errorReason", "�������");
			return Status.PASSWORDERROR;
		}
		
		
		return Status.SUCCESS;
	}
	
}