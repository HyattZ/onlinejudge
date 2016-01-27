package com.onlinejudge.aop;

import java.io.IOException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.PermissionCheck;
import com.onlinejudge.constant.ThreadLocalSession;
import com.onlinejudge.enums.Permission;

/**
 * @author ��Ц��
 *
 * @time 2015��9��20��
 * 
 */
@Aspect
@Component
public class PermissionInterceptor {
	@Before("com.onlinejudge.aop.SystemArchitecture.checkPermission()&&"+
			"@annotation(permissionCheck)")
	public void checkPermission(PermissionCheck permissionCheck) throws IOException{
		Permission permission = permissionCheck.value();
		Permission authPermission = (Permission) ThreadLocalSession.getSessionLocal().getAttribute("authPermission");
		
		if (!(authPermission != null && authPermission.equals(permission))){
			ThreadLocalSession.getResponseLocal().sendRedirect("/OnlineJudge");
		}
	}
}
