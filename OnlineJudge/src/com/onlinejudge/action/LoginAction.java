package com.onlinejudge.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.dto.LoginFormBean;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */
@Component("loginAction")
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
		//��¼��ɹ���һЩȫ�ֱ��������úʹ���
		User u = userService.getUserByUsername(lfb.getUsername());
		session.put("isLogin", true);
		session.put("stuid", u.getStuid());
		session.put("loginStatus", IsLogin.YES);
		return Status.SUCCESS;
	}
	
	private Date getDate(Date date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-NN-dd");
		String dateString = sdf.format(date);
		return sdf.parse(dateString);
	}
}
