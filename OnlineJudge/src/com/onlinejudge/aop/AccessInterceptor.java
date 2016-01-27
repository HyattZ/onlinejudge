package com.onlinejudge.aop;


import java.io.IOException;

import javax.naming.NoPermissionException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.ThreadLocalSession;
import com.onlinejudge.enums.IsLogin;

/**
 * @author 赵笑天
 *
 * @time 2015年9月20日
 * 
 */
@Aspect
@Component
public class AccessInterceptor{

	@Before("com.onlinejudge.aop.SystemArchitecture.accessToUrl()&&"+
			"@annotation(accessToUrl)")
	public void checkPermission(AccessToUrl accessToUrl) throws IOException{
		IsLogin isLogin = accessToUrl.value();
		IsLogin sessionLogin = (IsLogin) ThreadLocalSession.getSessionLocal().getAttribute("loginStatus");
		
		if (!sessionLogin.equals(isLogin)){
			ThreadLocalSession.getResponseLocal().sendRedirect("loginPage");
		}
	}


}
