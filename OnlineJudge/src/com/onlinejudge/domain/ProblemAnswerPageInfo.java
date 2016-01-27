package com.onlinejudge.domain;

/**
 * @author 赵笑天
 *
 * @time 2015年10月2日
 * 
 */
public class ProblemAnswerPageInfo {
	private int problemid;
	private String problemtitle;
	
	public ProblemAnswerPageInfo(){
		
	}
	

	public String getProblemtitle() {
		return problemtitle;
	}
	public void setProblemtitle(String problemtitle) {
		this.problemtitle = problemtitle;
	}


	public int getProblemid() {
		return problemid;
	}


	public void setProblemid(int problemid) {
		this.problemid = problemid;
	}
}
