package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author ��Ц��
 *
 * @time 2015��9��28��
 * 
 */
@Component("problemFormBean")
public class ProblemFormBean {
	private String problemtitle;
	private String problemcontent;
	private double mark;
	private int round;
	private String flag;
	
	public ProblemFormBean(){
		
	}
	
	public String getProblemtitle() {
		return problemtitle;
	}
	public void setProblemtitle(String problemtitle) {
		this.problemtitle = problemtitle;
	}
	public String getProblemcontent() {
		return problemcontent;
	}
	public void setProblemcontent(String problemcontent) {
		this.problemcontent = problemcontent;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(String markString) {
		try{
			mark = Double.parseDouble(markString);
		}catch(Exception e){
			mark = -1;
		}
	}

	public int getRound() {
		return round;
	}

	public void setRound(String round) {	
		try{
			this.round = Integer.parseInt(round);
		}catch(Exception e){
			this.round = -1;
		}
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public boolean validatePFB(){
		//���ֲ��ܷǷ�
		if (mark == -1 || round == -1){
			return false;
		}
		return true;
	}
}
