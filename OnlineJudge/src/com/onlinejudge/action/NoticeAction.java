package com.onlinejudge.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.Notice;
import com.onlinejudge.service.NoticeService;

/**
 * @author ��Ц��
 *
 * @time 2015��9��18��
 * 
 */
@Component
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
		Notice notice = noticeService.getLastestNotice();
		JSONObject json = new JSONObject();
		json.put("notice", notice);
		result = json.toString();
		return Status.SUCCESS;
	}
}
