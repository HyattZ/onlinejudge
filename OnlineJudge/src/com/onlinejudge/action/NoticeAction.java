package com.onlinejudge.action;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.Notice;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.NoticeService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月18日
 * 
 */
@Component("noticeAction")
public class NoticeAction {
	private String result;
	private NoticeService noticeService;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public NoticeService getNoticeService() {
		return noticeService;
	}
	@Resource(name="noticeServiceImpl")
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public String getLastestNotice(){
		try{
			Notice notice = noticeService.getLastestNotice();
			JSONObject json = new JSONObject();
			json.put("notice", notice);
			result = json.toString();
			return Status.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return Status.FAIL;
		}
	}
}
