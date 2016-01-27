package com.onlinejudge.action;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.enums.IsLogin;

/**
 * @author ��Ц��
 *
 * @time 2015��9��30��
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
