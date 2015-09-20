package com.onlinejudge.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ��Ц��
 *
 * @time 2015��9��20��
 * 
 */
@Aspect
@Component("systemArchitecture")
public class SystemArchitecture {
	
	@Pointcut("@annotation(com.onlinejudge.annotation.AccessToUrl)")
	public void accessToUrl(){}
	
	@Pointcut("@annotation(com.onlinejudge.annotation.PermissonCheck)")
	public void checkPermission(){}
}
