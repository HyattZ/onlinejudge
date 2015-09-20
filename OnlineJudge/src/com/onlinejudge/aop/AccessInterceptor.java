package com.onlinejudge.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;

/**
 * @author 赵笑天
 *
 * @time 2015年9月20日
 * 
 */
@Aspect
@Component("accessInterceptor")
public class AccessInterceptor {
	@Before("com.onlinejudge.aop.SystemArchitecture.accessToUrl()&&"+
			"@annotation(accessToUrl)")
	public void checkPermission(AccessToUrl accessToUrl){
		System.out.println("================================");
		System.out.println(accessToUrl.value());
	}
}
