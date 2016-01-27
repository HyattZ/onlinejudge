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
 * @time 2015年9月15日
 * 
 */
@Entity
@Table(name="notice")
public class Notice {
	private int noticeid;
	private String noticecontent;
	private Timestamp posttime;
	private String noticetitle;
	
	public Notice(){
		
	}

	public String getNoticecontent() {
		return noticecontent;
	}
	@Id
	@GeneratedValue
	public int getNoticeid() {
		return noticeid;
	}

	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}

	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}

	public Timestamp getPosttime() {
		return posttime;
	}

	public void setPosttime(Timestamp posttime) {
		this.posttime = posttime;
	}

	public String getNoticetitle() {
		return noticetitle;
	}

	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}

	@Override
	public String toString() {
		return "Notice [noticeid=" + noticeid + ", noticecontent="
				+ noticecontent + ", posttime=" + posttime + ", noticetitle="
				+ noticetitle + "]";
	}

}
