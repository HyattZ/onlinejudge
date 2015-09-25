package com.onlinejudge.domain.database;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author 赵笑天
 *
 * @time 2015年9月24日
 * 
 */
@Entity
@Table(name="submittimes")
public class SubmitTime {

	private int stuid;
	private int submittimes;
	private Timestamp recorddate;
	private int problemid;
	private int submittimesid;
	
	public SubmitTime(){
		
	}
	
	public int getProblemid() {
		return problemid;
	}

	public void setProblemid(int problemid) {
		this.problemid = problemid;
	}
	
	@Id
	@GeneratedValue
	public int getSubmittimesid() {
		return submittimesid;
	}

	public void setSubmittimesid(int submittimesid) {
		this.submittimesid = submittimesid;
	}
	
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public int getSubmittimes() {
		return submittimes;
	}
	public void setSubmittimes(int submittimes) {
		this.submittimes = submittimes;
	}

	public java.util.Date getRecorddate() {
		java.util.Date utilDate = new java.util.Date(recorddate.getTime());
		return utilDate;
	}
	public void setRecorddate(Timestamp recorddate) {
		this.recorddate = recorddate;
	}
	
}
