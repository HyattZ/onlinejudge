package com.onlinejudge.action;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;







import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.service.UserService;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */
public class RankAction implements ServletRequestAware{
	
	private Logger logger = Logger.getLogger(RankAction.class);
	private UserService userService;
	private HttpServletRequest request;
	private String result;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getRank(){
		try{
			JSONArray jsonArray = new JSONArray();
			jsonArray.addAll(userService.getUserList(5, 0));
			JSONObject json = new JSONObject();
			json.accumulate("users", jsonArray);
			result = json.toString();
			System.out.println(result);
			return Status.SUCCESS;
		}catch(Exception e){
			logger.error("��ȡ���а�ʧ�ܣ�ԭ��"+e.getMessage());
			return Status.FAIL;
		}
	}
	
}
