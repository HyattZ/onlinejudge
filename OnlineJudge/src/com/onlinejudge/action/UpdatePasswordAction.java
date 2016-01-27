package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.http.client.fluent.Request;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.dto.UpdatePasswordFormBean;
import com.onlinejudge.dto.UpdateUserFormBean;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.UserService;
import com.onlinejudge.tool.MD5;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ��Ц��
 *
 * @time 2015��10��2��
 * 
 */
@Component
public class UpdatePasswordAction implements ModelDriven,SessionAware,RequestAware{
	private UpdatePasswordFormBean upfb;
	private UserService userService;
	private Map<String,Object> session;
	private Map<String,Object> request;
	private String result;

	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public UpdatePasswordFormBean getUpfb() {
		return upfb;
	}
	@Resource(name="updatePasswordFormBean")
	public void setUpfb(UpdatePasswordFormBean upfb) {
		this.upfb = upfb;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public Object getModel() {
		return upfb;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	@AccessToUrl(IsLogin.YES)
	public String updatePassword(){
		String email = (String) session.get("email");
		User u = userService.getUserByEmail(email);
		JSONObject json = new JSONObject();
		try{
			if (upfb.validatePassword() && u.getPassword().equals(MD5.GetMD5Code(upfb.getOripassword()))){
					boolean status = userService.updateUser(upfb,email);
					if (status){
						json.put("status", true);
						json.put("message", "���³ɹ�");
						result = json.toString();
						return Status.SUCCESS;
					}else{
						json.put("status", false);
						json.put("message", "д�����ݿ�ʧ�ܣ�");
						result = json.toString();
						return Status.FAIL;
					}
			}else{
				json.put("status", false);
				json.put("message", "�����Ƿ���ԭʼ�������");
				result = json.toString();
				return Status.PARAMSILLEGAL;
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", false);
			json.put("message", "�����쳣д��ʧ�ܣ�");
			result = json.toString();
			return Status.FAIL;
		}
	}

}
