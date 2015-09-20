package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
@Component("registerFormBean")
public class RegisterFormBean {
	private int stuid;
	private String username;
	private String password;
	private String nickname;
	private String qq;
	private String phonenum;
	private String email;
	private String faviconuri;
	
	public RegisterFormBean(){
		
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaviconuri() {
		return faviconuri;
	}

	public void setFaviconuri(String faviconuri) {
		this.faviconuri = faviconuri;
	}
	
	/**
	 * 
	 * 功能：验证邮箱，验证规则是符合邮箱条件，并且长度小于数据库字段长度
	 * 
	 * */
	
	public boolean validateEmail(){
		String regex="w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*";
		if (email.matches(regex) && email.length()<35){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * 功能：验证密码，验证规则是数字或字母组成的字段长度为(6,18]的字符串
	 * 
	 * */
	
	public boolean validatePassword(){
		String regex = "^[A-Za-z0-9]+$";
		return (this.password.matches(regex)&this.password.length()>6 &this.password.length()<=18);
	}
	
	/**
	 * 
	 * 功能：验证用户名，验证规则是数字或字母组成的字段长度为(6,20]的字符串
	 * 
	 * */
	
	public boolean validateUserName(){
		String regex = "^[A-Za-z0-9]+$";
		return (this.username.matches(regex) & this.username.length() >6 & this.username.length() <=20);
	}
	
	/**
	 * 
	 * 功能：验证手机号，验证规则是现在发出的所有号段
	 * 
	 * */
	
	public boolean validatePhonenum(){
		String regex = "^[1][34578][0-9]{9}$";
		return (this.phonenum.matches(regex) & this.phonenum.length() == 11);
	}
	
	/**
	 * 
	 * 功能：验证qq号，验证规则是现在已有的qq
	 * 
	 * */
	
	public boolean validateQQ(){
		String regex = "[1-9][0-9]{4,10}";
		return (this.qq.matches(regex));
	}
	
	/**
	 * 
	 * 功能：验证昵称，可以使中英文或数字的集合,长度(0,35)
	 * 
	 * */
	public boolean validateNickName(){
		String regex ="[^x00-xff]";
		return (this.nickname.matches(regex)&this.nickname.length()<35&this.nickname.length()>0);
	}
	
	public boolean validateFaviconuri(){
		String regex = "http://localhost:8080/OnlineJudege";
		return this.faviconuri.matches(regex);
		
	}
	
	public boolean validateStuId(){
		return true;
	}
}
