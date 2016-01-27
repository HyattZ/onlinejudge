package com.onlinejudge.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.annotation.PermissionCheck;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.NoticeInfo;
import com.onlinejudge.domain.database.Notice;
import com.onlinejudge.dto.NoticeFormBean;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.enums.Permission;
import com.onlinejudge.service.NoticeService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ��Ц��
 *
 * @time 2015��9��18��
 * 
 */
@Component("noticeAction")
public class NoticeAction implements ModelDriven,RequestAware{
	private String result;
	private NoticeService noticeService;
	private NoticeFormBean noticeFormBean;
	private int noticePage;
	private Map<String,Object> request;
	
	public int getNoticePage() {
		return noticePage;
	}
	
	public void setNoticePage(String noticePageString) {
		try{
			this.noticePage = Integer.parseInt(noticePageString);
			if (this.noticePage < 1){
				this.noticePage = 1;
			}
		}catch(Exception e){
			this.noticePage = 1 ;
		}
	}
	
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
	
	public NoticeFormBean getNoticeFormBean() {
		return noticeFormBean;
	}
	@Resource(name="noticeFormBean")
	public void setNoticeFormBean(NoticeFormBean noticeFormBean) {
		this.noticeFormBean = noticeFormBean;
	}

	@Override
	public Object getModel() {
		return noticeFormBean;
	}
	
	
	public String getLastestNotice(){
		try{
			NoticeInfo noticeInfo = noticeService.getLastestNotice();
			
			JSONObject json = new JSONObject();
			json.put("notice", noticeInfo);
			result = json.toString();
			return Status.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return Status.FAIL;
		}
	}
	
	@PermissionCheck(Permission.Administrator)
	public String addNotice(){
		boolean flag = false;
		try{
			flag = noticeService.addNotice(noticeFormBean);
		}catch(Exception e){
			flag = false;
		}
		JSONObject json = new JSONObject();
		json.accumulate("status", flag);
		result = json.toString();
		return Status.SUCCESS;
	}
	
	public String getNoticeList(){
		try{
			JSONArray jsonArray  = new JSONArray();
			int noticeCount = noticeService.getNoticeCount();
			int maxPage = noticeCount / 10;
			if (noticeCount % 10 > 0){
				maxPage ++;
			}
			
			//����������Ĳ��������ܵõ������ݣ��Ϳ���noticePage����ֵʹ֮����""
			if (noticePage > maxPage){
				noticePage = maxPage +1 ;
			}
			//���ֻ�ò�ѯ80������
			if (maxPage > 8){
				maxPage = 8;
			}
			
			//��������һҳ
			if (noticePage == maxPage){
				request.put("noticesNum", noticeCount%10);
			}else{
				request.put("noticesNum", 10);
			}
			
			if (noticePage <= maxPage){
				jsonArray.addAll(noticeService.getNoticeList((noticePage-1)*10,10));
				long[] indexs = new long[2];
				indexs = getIndexs(noticeCount,10);
				JSONObject json = new JSONObject();
				json.accumulate("notices", jsonArray);
				if (indexs[1] > 8){
					indexs[1] = 8;
					indexs[0] = 4;
				}
				json.accumulate("noticeBeginIndex", indexs[0]);
				json.accumulate("noticeEndIndex", indexs[1]);
				json.accumulate("noticeMaxPage", maxPage);
				json.accumulate("noticePage", noticePage);
				json.accumulate("noticesNum", jsonArray.size());
				result = json.toString();
			}else{
				result = "";
			}
			return Status.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return Status.FAIL;
		}
	}
	
	public long[] getIndexs(long count, long length) {
		long[] indexs = new long[2];

		// ��ȡ���Եõ������ҳ����
		long maxIndex = count / length;
		long tmp = count % length;

		if (tmp != 0) {
			maxIndex += 1;
		}

		
		if (maxIndex < length) {
			// �������ҳ����С��Ҫչʾ�ĳ����ķ�ҳ����ô��ʼΪ1������Ϊ���ҳ����
			indexs[0] = 1;
			indexs[1] = maxIndex;
		} else {
			// ���ÿ�ʼ������
			if ((maxIndex - noticePage) < length) {
				indexs[0] = maxIndex - length + 1;
			} else {
				indexs[0] = noticePage;
			}

			// ���ý���������
			if ((maxIndex - noticePage) < length) {
				indexs[1] = maxIndex;
			} else {
				indexs[1] = noticePage + length - 1;
			}
		}
		return indexs;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
