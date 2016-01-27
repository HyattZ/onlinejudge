package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.onlinejudge.annotation.PermissionCheck;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.Admin;
import com.onlinejudge.dto.AdminLoginFormBean;
import com.onlinejudge.enums.Permission;
import com.onlinejudge.service.AdminService;
import com.onlinejudge.tool.MD5;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 赵笑天
 *
 * @time 2015年10月4日
 * 
 */
public class AdminLoginAction implements SessionAware,ModelDriven,ServletRequestAware{
		private AdminLoginFormBean alfb;
		private Map<String,Object> session;
		private AdminService adminService;
		private HttpServletRequest request;

		public AdminLoginFormBean getAlfb() {
			return alfb;
		}
		
		@Resource(name="adminLoginFormBean")
		public void setAlfb(AdminLoginFormBean alfb) {
			this.alfb = alfb;
		}

		public AdminService getAdminService() {
			return adminService;
		}
		@Resource(name="adminServiceImpl")
		public void setAdminService(AdminService adminService) {
			this.adminService = adminService;
		}

		@Override
		public Object getModel() {
			return alfb;
		}

		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}
		
		public String checkAdminLogin(){
			if ("POST".equals(request.getMethod())) {
			if (alfb.validateAdminname() && alfb.validateAuthCode((String) session.get("authcode"))){
				Admin admin = getAdminService().getAdminByAdminname(alfb.getAdminname());
				if (admin != null && admin.getAdminpassword().equals(MD5.GetMD5Code(alfb.getAdminpassword()))){
					session.put("authPermission", Permission.Administrator);
					System.out.println(session.get("authPermission"));
					return Status.SUCCESS;
				}
				session.put("errorReason", "用户名与密码不匹配！");
				return Status.FAIL;
			}else{
				session.put("errorReason", "验证码错误或用户名不合法！");
				return Status.FAIL;
			}
			}else{
				return Status.FAIL;
			}
		}
		
		@PermissionCheck(Permission.Administrator)
		public String getManagePage(){
			return Status.SUCCESS;
		}

		@Override
		public void setServletRequest(HttpServletRequest request) {
			this.request = request;
		}
}
