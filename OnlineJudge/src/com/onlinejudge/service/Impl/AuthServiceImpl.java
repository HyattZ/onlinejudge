package com.onlinejudge.service.Impl;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.AuthService;

/**
 * @author ��Ц��
 *
 * @time 2015��9��26��
 * 
 */

public class AuthServiceImpl implements AuthService{
	
	public  boolean checkAccessToUrl(IsLogin isLogin){
		/*IsLogin sessionIsLogin = (IsLogin) .get("loginStatus")*/;
		
		/*if (sessionIsLogin.equals(isLogin)){
			return true;
		}*/
		
		return false;
	}


}
