package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author 赵笑天
 *
 * @time 2015年9月17日
 * 
 */
@Component("resultFormBean")
public class ResultFormBean {
	private int problemid;
	private String flag;
	
	public ResultFormBean(){
		
	}
	
	public int getProblemid() {
		return problemid;
	}
	public void setProblemid(int problemid) {
		
		this.problemid = problemid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * 
	 * 功能：验证flag的合法性,验证规则，字母和数字构成的长度不超过100的字符串
	 * 
	 * */
	public boolean validateFlag(){
		String regex = "[A-Za-z0-9]+";
		return (this.flag.matches(regex) & this.flag.length() < 100 );
	}
	
}
