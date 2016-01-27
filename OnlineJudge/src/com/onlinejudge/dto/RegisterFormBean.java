package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author 赵笑天
 *
 * @time 2015年9月23日
 * 
 */
@Component("registerFormBean")
public class RegisterFormBean {
	
	private int stuid;
	private String username;
	private String realname;
	private String password;
	private String passwordAgain;
	private String email;
	private String authCode;
	private String qq;
	private String phonenum;
	
	public int getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		try{
			String regex = "^\\d{9}$";
			if (stuid.matches(regex)){
				int stuidNum = Integer.parseInt(stuid);
				this.stuid = stuidNum;
			}else{
				this.stuid = -1;
			}
		}catch(Exception e){
			this.stuid = -1;
		}

	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthCode() {
		return authCode;
	}
	
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	public boolean validateEmail() {
		String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		if (this.email.matches(regex)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean validateAuthCode(String authCode){
		return authCode.equalsIgnoreCase(this.authCode);
	}
	
	public boolean validateRealName() {
		String regex = "^[\u4e00-\u9fa5]{2,}$";
		if (this.realname.matches(regex)){
			return true;
		}else{
			return false;
		}
	}

	public boolean validatePassword() {
		String regex = "^[A-Za-z0-9]{6,18}$";
		if (this.password.matches(regex) && this.password.equals(this.passwordAgain)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateQQ(){
		String regex = "^[1-9][0-9]{4,9}$";
		if (this.qq.matches(regex)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validatePhonenum(){
		String regex = "^1\\d{10}$";
		if (this.phonenum.matches(regex)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateStuid() {
		if (this.stuid != -1){
			return true;
		}else{
			return false;
		}
	}

	public boolean validateUserName() {
		String regex = "^[\u4e00-\u9fa5_a-zA-Z0-9]+$";
		if (this.username.matches(regex) && username.length() < 35 && username.length() > 0){
			return true;
		}else{
			return false;
		}
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	
	@Override
	public String toString() {
		return "RegisterFormBean [stuid=" + stuid + ", username=" + username
				+ ", realname=" + realname + ", password=" + password
				+ ", passwordAgain=" + passwordAgain + ", email=" + email
				+ ", authCode=" + authCode + ", qq=" + qq + ", phonenum="
				+ phonenum + "]";
	}
}
