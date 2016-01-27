package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author 赵笑天
 *
 * @time 2015年10月4日
 * 
 */
@Component("adminLoginFormBean")
public class AdminLoginFormBean {
	private String adminname;
	private String adminpassword;
	private String authCode;
	
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	public boolean validateAdminname(){
		String regex = "^[a-zA-Z]\\w{1,24}$";
		if (this.adminname.matches(regex)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateAuthCode(String authCode){
		return authCode.equalsIgnoreCase(this.authCode);
	}
	
	@Override
	public String toString() {
		return "AdminLoginFormBean [adminname=" + adminname
				+ ", adminpassword=" + adminpassword + ", authCode=" + authCode
				+ "]";
	}
	
	
}
