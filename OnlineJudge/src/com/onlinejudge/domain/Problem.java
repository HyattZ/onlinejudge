package com.onlinejudge.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
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
	
	public Problem(){
		
	}

	public String getFlag() {
		return flag;
	}

	public double getMark() {
		return mark;
	}
	@Id
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

	public String getProblemtitle() {
		return problemtitle;
	}

	public void setProblemtitle(String problemtitle) {
		this.problemtitle = problemtitle;
	}

	@Override
	public String toString() {
		return "Problem [problemid=" + problemid + ", flag=" + flag + ", mark="
				+ mark + ", problemtitle=" + problemtitle + "]";
	}
}
