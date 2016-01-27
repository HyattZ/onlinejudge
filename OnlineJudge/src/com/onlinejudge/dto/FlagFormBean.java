package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author ��Ц��
 *
 * @time 2015��9��22��
 * 
 */
@Component("flagFormBean")
public class FlagFormBean {
	private int problemid;
	private String flag;
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
	
	public boolean validateProblemid(){
		return true;
	}
	
	public boolean validateFlag(){
		return true;
	}
	
	@Override
	public String toString() {
		return "FlagFormBean [problemid=" + problemid + ", flag=" + flag + "]";
	}
}
