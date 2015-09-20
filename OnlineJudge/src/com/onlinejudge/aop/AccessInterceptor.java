package com.onlinejudge.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;

/**
 * @author ��Ц��
 *
 * @time 2015��9��20��
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
