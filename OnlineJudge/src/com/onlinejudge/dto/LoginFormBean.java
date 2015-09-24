package com.onlinejudge.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.onlinejudge.tool.MD5;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
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
	 * ���û������м�飬�����������sqlע��
	 * 
	 **/
	
	public boolean validateUserName(){
		//������ʽƥ��ֻ�����ֺ���ĸ��ɵ��ַ���,���Ȳ������ֶγ�
		String regex = "^[A-Za-z0-9]+$";
		return (username.matches(regex)&username.length()<35);
	}
}
