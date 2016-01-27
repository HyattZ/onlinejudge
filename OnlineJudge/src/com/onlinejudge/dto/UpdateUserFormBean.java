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

	private String username;
	private String realname;
	private String qq;
	private String phonenum;
	
	public UpdateUserFormBean(){
		
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

	@Override
	public String toString() {
		return "UpdateUserFormBean [username=" + username + ", realname="
				+ realname + ", qq=" + qq + ", phonenum=" + phonenum + "]";
	}
	
	public boolean validateRealName() {
		String regex = "^[\u4e00-\u9fa5]{2,}$";
		if (this.realname.matches(regex)){
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
	
	public boolean validateUserName() {
		String regex = "^[a-zA-Z]\\w{5,24}$";
		if (this.username.matches(regex)){
			return true;
		}else{
			return false;
		}
	}
}
