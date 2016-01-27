package com.onlinejudge.domain;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
public class ProblemListItem {
	private int problemid;
	private String problemtitle;
	private double mark;
	private int isComplete;
	private int submitTimes;
	
	public int getProblemid() {
		return problemid;
	}
	public void setProblemid(int problemid) {
		this.problemid = problemid;
	}
	public String getProblemtitle() {
		return problemtitle;
	}
	public void setProblemtitle(String problemtitle) {
		this.problemtitle = problemtitle;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public int getIsComplete() {
		return isComplete;
	}
	/**
	 * 
	 * -1表示为完成，1表示已经完成，0表示未知状态
	 * 
	 * */
	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}
	
	public int getSubmitTimes() {
		return submitTimes;
	}
	public void setSubmitTimes(int submitTimes) {
		this.submitTimes = submitTimes;
	}
}
