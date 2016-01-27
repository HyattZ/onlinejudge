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
	 * ���û������м�飬�����������sqlע��
	 * 
	 **/
	
	public boolean validateEmail(){
		//������ʽƥ��ֻ�����ֺ���ĸ��ɵ��ַ���,���Ȳ������ֶγ�
		String regex = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
		return (email.matches(regex) && email.length() < 35);
	}

}
