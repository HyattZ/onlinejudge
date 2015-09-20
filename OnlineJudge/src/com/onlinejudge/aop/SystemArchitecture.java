package com.onlinejudge.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 赵笑天
 *
 * @time 2015年9月20日
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
