package com.onlinejudge.domain.database;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name="record")
public class Record {
	private int recordid;
	private int stuid;
	private int problemid;
	private String submitflag;
	private String submittime;
	
	public Record(){
		
	}
	
	@Id
	public int getRecordid() {
		return recordid;
	}

	public String getSubmitflag() {
		return submitflag;
	}
	
	public String getSubmittime() {
		return submittime;
	}
		
	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}
	
	public void setSubmitflag(String submitflag) {
		this.submitflag = submitflag;
	}


	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}


	public int getStuid() {
		return stuid;
	}


	public void setStuid(int stuid) {
		this.stuid = stuid;
	}


	public int getProblemid() {
		return problemid;
	}


	public void setProblemid(int problemid) {
		this.problemid = problemid;
	}

	@Override
	public String toString() {
		return "Record [recordid=" + recordid + ", stuid=" + stuid
				+ ", problemid=" + problemid + ", submitflag=" + submitflag
				+ ", submittime=" + submittime + "]";
	}

}
