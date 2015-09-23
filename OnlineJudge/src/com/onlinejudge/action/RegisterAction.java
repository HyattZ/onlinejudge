package com.onlinejudge.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.dto.RegisterFormBean;
import com.onlinejudge.service.UserService;
import com.onlinejudge.tool.MD5;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ��Ц��
 *
 * @time 2015��9��16��
 * 
 */
public class RegisterAction implements ModelDriven{
	private Logger logger = Logger.getLogger(RegisterAction.class);
	private RegisterFormBean rfb;
	private UserService userService;
	private String result;
	
	@Override
	public Object getModel() {
		return getRfb();
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RegisterFormBean getRfb() {
		return rfb;
	}
	@Resource(name="registerFormBean")
	public void setRfb(RegisterFormBean rfb) {
		this.rfb = rfb;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String register(){
		
		User u = new User();
		 
		if (rfb.validateEmail()){
			u.setEmail(getRfb().getEmail());
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (rfb.validateFaviconuri()){
			u.setFaviconuri(getRfb().getFaviconuri());
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (rfb.validateNickName()){
			u.setNickname(getRfb().getNickname());
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (rfb.validatePassword()){
			u.setPassword(MD5.GetMD5Code(getRfb().getPassword()));
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (rfb.validatePhonenum()){
			u.setPhonenum(getRfb().getPhonenum());
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (rfb.validateQQ()){
			u.setQq(getRfb().getQq());
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (rfb.validateStuId()){
			u.setStuid(getRfb().getStuid());
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (rfb.validateUserName()){
			u.setUsername(getRfb().getUsername());
		}else{
			return Status.PARAMSILLEGAL;
		}
		
		if (getUserService().saveUser(u)){
			return Status.SUCCESS;
		}else{
			return Status.FAIL;
		}
		
	}
	
	/**
	 * 
	 * @return userNameStatus = true �û�������
	 * 					userNameStatus = false �û���������
	 * 
	 * */
	
	public String checkUsername(){
		Map<String , Boolean> map = new HashMap<String,Boolean>();
		if (getRfb().validateUserName()){
			boolean status = getUserService().checkUsername(getRfb().getUsername());
			/*System.out.println(status);*/
			map.put("usernameStatus", status);
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return Status.SUCCESS;
		}else{
			map.put("usernameStatus", false);
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return Status.FAIL;
		}
		
	}
	
	public String checkStuId(){
		Map<String , Boolean> map = new HashMap<String,Boolean>();
		boolean status = userService.checkStuId(rfb.getStuid());
		System.out.println(status);
		map.put("stuidStatus", status);
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		return Status.SUCCESS;
		
	}
}
