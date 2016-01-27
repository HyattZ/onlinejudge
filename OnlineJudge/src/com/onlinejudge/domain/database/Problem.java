package com.onlinejudge.domain.database;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Entity
@Table(name="problem")
public class Problem {
	
	private int problemid;
	private String flag;
	private double mark;
	private String problemtitle;
	private Set<Record> records;
	private String problemcontent;
	private Set<SubmitTime> submittimes;
	private int round;
	
	public Problem(){
		
	}
		
	public String getProblemcontent() {
		return problemcontent;
	}

	public void setProblemcontent(String problemcontent) {
		this.problemcontent = problemcontent;
	}

	public String getFlag() {
		return flag;
	}

	public double getMark() {
		return mark;
	}
	@Id
	@GeneratedValue
	public int getProblemid() {
		return problemid;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public void setProblemid(int problemid) {
		this.problemid = problemid;
	}
	
	@OneToMany
	@JoinColumn(name="problemid")
	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}
	
	@OneToMany
	@JoinColumn(name="problemid")
	public Set<SubmitTime> getSubmittimes() {
		return submittimes;
	}

	
	public void setSubmittimes(Set<SubmitTime> submittimes) {
		this.submittimes = submittimes;
	}


	public String getProblemtitle() {
		return problemtitle;
	}

	public void setProblemtitle(String problemtitle) {
		this.problemtitle = problemtitle;
	}

	public int getRound() {
		return round;
	}
	
	public void setRound(int round) {
		this.round = round;
	}


	@Override
	public String toString() {
		return "Problem [problemid=" + problemid + ", flag=" + flag + ", mark="
				+ mark + ", problemtitle=" + problemtitle + ", records="
				+ records + ", problemcontent=" + problemcontent + "]";
	}
}
