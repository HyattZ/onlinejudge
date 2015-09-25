package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author 赵笑天
 *
 * @time 2015年9月24日
 * 
 */
@Component("updateUserFormBean")
public class UpdateUserFormBean {
	private int stuid;
	private String username;
	private String password;
	private String realname;
	private String qq;
	private String phonenum;
	private String email;
	
	public UpdateUserFormBean(){
		
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
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
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

	@Override
	public String toString() {
		return "UpdateUserFormBean [stuid=" + stuid + ", username=" + username
				+ ", password=" + password + ", realname=" + realname + ", qq="
				+ qq + ", phonenum=" + phonenum + ", email=" + email + "]";
	}
}
