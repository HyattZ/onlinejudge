package com.onlinejudge.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 赵笑天
 *
 * @time 2015年9月27日
 * 
 */
public class NoticeInfo {
	private int noticeid;
	private String noticecontent;
	private String posttime;
	private String noticetitle;
	
	public int getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}
	public String getNoticecontent() {
		return noticecontent;
	}
	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}

	public String getNoticetitle() {
		return noticetitle;
	}
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}
	public String getPosttime() {
		return posttime;
	}
	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}
}
