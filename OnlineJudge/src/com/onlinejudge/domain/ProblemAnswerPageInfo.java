package com.onlinejudge.domain;

/**
 * @author ��Ц��
 *
 * @time 2015��10��2��
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
