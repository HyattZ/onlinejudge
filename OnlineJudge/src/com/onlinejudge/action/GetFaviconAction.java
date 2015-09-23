package com.onlinejudge.action;

import com.onlinejudge.constant.Status;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
public class GetFaviconAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String stuid;
	
	public String getStuid() {
		return stuid;
	}
	
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	
	public String getFavicon(){
		return Status.SUCCESS;
	}
}
