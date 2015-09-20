package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author ��Ц��
 *
 * @time 2015��9��16��
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
	 * ���ܣ���֤���䣬��֤�����Ƿ����������������ҳ���С�����ݿ��ֶγ���
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
	 * ���ܣ���֤���룬��֤���������ֻ���ĸ��ɵ��ֶγ���Ϊ(6,18]���ַ���
	 * 
	 * */
	
	public boolean validatePassword(){
		String regex = "^[A-Za-z0-9]+$";
		return (this.password.matches(regex)&this.password.length()>6 &this.password.length()<=18);
	}
	
	/**
	 * 
	 * ���ܣ���֤�û�������֤���������ֻ���ĸ��ɵ��ֶγ���Ϊ(6,20]���ַ���
	 * 
	 * */
	
	public boolean validateUserName(){
		String regex = "^[A-Za-z0-9]+$";
		return (this.username.matches(regex) & this.username.length() >6 & this.username.length() <=20);
	}
	
	/**
	 * 
	 * ���ܣ���֤�ֻ��ţ���֤���������ڷ��������кŶ�
	 * 
	 * */
	
	public boolean validatePhonenum(){
		String regex = "^[1][34578][0-9]{9}$";
		return (this.phonenum.matches(regex) & this.phonenum.length() == 11);
	}
	
	/**
	 * 
	 * ���ܣ���֤qq�ţ���֤�������������е�qq
	 * 
	 * */
	
	public boolean validateQQ(){
		String regex = "[1-9][0-9]{4,10}";
		return (this.qq.matches(regex));
	}
	
	/**
	 * 
	 * ���ܣ���֤�ǳƣ�����ʹ��Ӣ�Ļ����ֵļ���,����(0,35)
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
