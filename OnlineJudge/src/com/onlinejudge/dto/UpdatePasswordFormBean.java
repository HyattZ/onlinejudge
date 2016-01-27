package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

import com.onlinejudge.tool.MD5;

/**
 * @author 赵笑天
 *
 * @time 2015年10月2日
 * 
 */
@Component("updatePasswordFormBean")
public class UpdatePasswordFormBean {
	
	private String password;
	private String passwordAgain;
	private String oripassword;
	
	public UpdatePasswordFormBean(){
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordAgain() {
		return passwordAgain;
	}
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
	public String getOripassword() {
		return oripassword;
	}
	public void setOripassword(String oripassword) {
		this.oripassword = oripassword;
	}
	

	public boolean validatePassword() {
		String regex = "^[A-Za-z0-9]{6,18}$";
		if (this.password.matches(regex) && this.password.equals(this.passwordAgain)){
			return true;
		}else{
			return false;
		}
	}
}
