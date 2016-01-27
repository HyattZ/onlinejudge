package com.onlinejudge.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.dto.RegisterFormBean;
import com.onlinejudge.service.UserService;
import com.onlinejudge.tool.MD5;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */

@Component("registerAction")
public class RegisterAction implements ModelDriven, SessionAware,ServletRequestAware {
	private Logger logger = Logger.getLogger(RegisterAction.class);
	private RegisterFormBean rfb;
	private UserService userService;
	private String result;
	private Map<String, Object> session;
	private HttpServletRequest request;

	@Override
	public Object getModel() {
		return getRfb();
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RegisterFormBean getRfb() {
		return rfb;
	}

	@Resource(name = "registerFormBean")
	public void setRfb(RegisterFormBean rfb) {
		this.rfb = rfb;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String register() {
		if ("POST".equals(request.getMethod())) {
			User u = new User();
			String authCode = (String) session.get("authcode");
			session.remove("authcode");
			if (!rfb.validateAuthCode(authCode)) {
				session.put("errorReason", "验证码错误！");
				return Status.PARAMSILLEGAL;
			}

			if (rfb.validateQQ()) {
				u.setQq(rfb.getQq());
			} else {
				session.put("errorReason", "QQ号非法！");
				return Status.PARAMSILLEGAL;
			}

			if (rfb.validatePhonenum()) {
				u.setPhonenum(rfb.getPhonenum());
			} else {
				session.put("errorReason", "电话号码非法！");
				return Status.PARAMSILLEGAL;
			}

			if (rfb.validateEmail()) {
				u.setEmail(getRfb().getEmail());
			} else {
				session.put("errorReason", "邮箱非法！");
				return Status.PARAMSILLEGAL;
			}

			if (rfb.validateRealName()) {
				u.setRealname(getRfb().getRealname());
			} else {
				session.put("errorReason", "真实姓名非法！");
				return Status.PARAMSILLEGAL;
			}

			if (rfb.validatePassword()) {
				u.setPassword(MD5.GetMD5Code(getRfb().getPassword()));
			} else {
				session.put("errorReason", "密码错误！");
				return Status.PARAMSILLEGAL;
			}

			if (rfb.validateStuid()) {
				u.setStuid(getRfb().getStuid());
			} else {
				session.put("errorReason", "学号非法！");
				return Status.PARAMSILLEGAL;
			}

			if (rfb.validateUserName()) {
				u.setUsername(getRfb().getUsername());
			} else {
				session.put("errorReason", "用户名非法！");
				return Status.PARAMSILLEGAL;
			}

			System.out.println(u);

			if (getUserService().saveUser(u)) {
				session.put("successPageTitle", "成功");
				session.put("successMessage", "注册成功");
				return Status.SUCCESS;
			} else {
				return Status.FAIL;
			}
		} else {
			return Status.FAIL;
		}
	}

	/**
	 * 
	 * @return userNameStatus = true 用户名可用 userNameStatus = false 用户名不可用
	 * 
	 * */

	public String checkUsername() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (getRfb().validateUserName()) {
			boolean status = getUserService().checkUsername(
					getRfb().getUsername());
			/* System.out.println(status); */
			map.put("usernameStatus", status);
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return Status.SUCCESS;
		} else {
			map.put("usernameStatus", false);
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return Status.FAIL;
		}

	}

	public String checkStuId() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		boolean status = false;

		if (rfb.validateStuid()) {
			status = userService.checkStuId(rfb.getStuid());
		}

		map.put("stuidStatus", status);
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		return Status.SUCCESS;

	}

	public String checkEmail() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		boolean status = false;
		if (rfb.validateEmail()) {
			status = userService.checkEmail(rfb.getEmail());
		}
		map.put("emailStatus", status);
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		return Status.SUCCESS;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request  = request;
	}

}
