package com.onlinejudge.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author ��Ц��
 *
 * @time 2015��9��28��
 * 
 */
@Component("noticeFormBean")
public class NoticeFormBean {
	private String noticetitle;
	private String noticecontent;
	
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
}
