package com.onlinejudge.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.PermissionCheck;
import com.onlinejudge.enums.Permission;

/**
 * @author 赵笑天
 *
 * @time 2015年9月20日
 * 
 */
@Aspect
@Component
public class PermissionInterceptor {
	@Before("com.onlinejudge.aop.SystemArchitecture.checkPermission()&&"+
			"@annotation(permission)")
	public void checkPermission(PermissionCheck permission){
		System.out.println(permission.value()[0]);
	}
}
