package com.onlinejudge.action;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.enums.IsLogin;

/**
 * @author 赵笑天
 *
 * @time 2015年9月30日
 * 
 */
public class GetPDFAction {
	private static final long serialVersionUID = 1L;
	private String problemid;
	
	public String getProblemid() {
		return problemid;
	}

	public void setProblemid(String problemid) {
		this.problemid = problemid;
	}

	@AccessToUrl(IsLogin.YES)
	public String getPDF(){
		return Status.SUCCESS;	
	}
}
