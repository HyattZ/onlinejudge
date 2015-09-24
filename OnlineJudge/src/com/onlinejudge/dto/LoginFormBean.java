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
	private String username;
	private String password;
	private String authCode;

	public LoginFormBean(){
		
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validatePassword(String password){

		if (password.equals(MD5.GetMD5Code(this.password))){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateAuthCode(String authCode){
	
		if (this.authCode.equals(authCode)){
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
	
	public boolean validateUserName(){
		//正则表达式匹配只有数字和字母组成的字符串,长度不超过字段长
		String regex = "^[A-Za-z0-9]+$";
		return (username.matches(regex)&username.length()<35);
	}
}
