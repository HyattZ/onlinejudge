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
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Component("loginAction")
public class LoginAction implements ServletRequestAware, SessionAware,
		ModelDriven {
	private Logger logger = Logger.getLogger(LoginAction.class);
	private HttpServletRequest request;
	private Map<String, Object> session;
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

	@Resource(name = "loginFormBean")
	public void setLfb(LoginFormBean lfb) {
		this.lfb = lfb;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String checkLogin() {
		/**
		 * 
		 * 功能：验证账号密码验证码登录
		 * 
		 * */
		if ("POST".equals(request.getMethod())) {
			String authCode = (String) session.get("authcode");
			session.remove("authcode");
			if (!lfb.validateAuthCode(authCode)) {

				session.put("errorReason", "验证码错误！");
				return Status.AUTHCODEERROR;
			}

			if (!lfb.validateEmail()) {
				session.put("errorReason", "用户名非法！");
				return Status.AUTHCODEERROR;
			}

			if (!lfb.validatePassword(userService.getPasswordByEmail(lfb
					.getEmail()))) {
				session.put("errorReason", "密码错误！");
				return Status.PASSWORDERROR;
			}
			// 登录完成过后一些全局变量的设置和处理
			User u = userService.getUserByEmail(lfb.getEmail());
			
			u = userService.init(u);
			session.put("isLogin", true);
			session.put("stuid", u.getStuid());
			session.put("loginStatus", IsLogin.YES);
			session.put("username", u.getUsername());
			session.put("email", u.getEmail());
			session.put("score", u.getScore().getScore());
			session.put("weeklyScore", u.getWeeklyScore().getScore());
			return Status.SUCCESS;
		} else {
			return Status.FAIL;
		}
	}

	private Date getDate(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-NN-dd");
		String dateString = sdf.format(date);
		return sdf.parse(dateString);
	}
}
