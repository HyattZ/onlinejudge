package com.onlinejudge.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.onlinejudge.tool.MD5;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Component("loginFormBean")
public class LoginFormBean {
	private String email;
	private String password;
	private String authCode;

	public LoginFormBean(){
		
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
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validatePassword(String password){
		System.out.println(password);
		System.out.println(MD5.GetMD5Code(this.password));
		if (password.equals(MD5.GetMD5Code(this.password))){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateAuthCode(String authCode){
	
		if (this.authCode.equalsIgnoreCase(authCode)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 	
	 * 对用户名进行检查，避免最基本的sql注入
	 * 
	 **/
	
	public boolean validateEmail(){
		//正则表达式匹配只有数字和字母组成的字符串,长度不超过字段长
		String regex = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
		return (email.matches(regex) && email.length() < 35);
	}

}
