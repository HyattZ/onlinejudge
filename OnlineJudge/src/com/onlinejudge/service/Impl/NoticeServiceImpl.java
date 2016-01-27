package com.onlinejudge.service.Impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.NoticeDao;
import com.onlinejudge.domain.NoticeInfo;
import com.onlinejudge.domain.database.Notice;
import com.onlinejudge.dto.NoticeFormBean;
import com.onlinejudge.service.NoticeService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月17日
 * 
 */
@Component("noticeServiceImpl")
public class NoticeServiceImpl implements NoticeService{
	private NoticeDao noticeDao;

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}
	@Resource(name="noticeDaoImpl")
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public NoticeInfo getLastestNotice() {
		Notice notice = noticeDao.getLastestNotice();
		if (notice != null){
			NoticeInfo noticeInfo = new NoticeInfo();
			
			noticeInfo.setNoticeid(notice.getNoticeid());
			noticeInfo.setNoticetitle(notice.getNoticetitle());
			noticeInfo.setNoticecontent(notice.getNoticecontent());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String postTimeString = sdf.format(notice.getPosttime().getTime());
			noticeInfo.setPosttime(postTimeString);

			return noticeInfo;
		}else{
			return null;
		}
	}
	
	@Override
	public boolean addNotice(NoticeFormBean noticeFormBean) {
		
		try {
			Notice notice = new Notice();
			notice.setNoticecontent(noticeFormBean.getNoticecontent());
			notice.setNoticetitle(noticeFormBean.getNoticetitle());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = sdf.format(new Date());
			notice.setPosttime(new Timestamp(sdf.parse(dateString).getTime()));
			return noticeDao.saveNotice(notice);
			
		} catch (ParseException e) {
			return false;
		}
	}

	@Override
	public List<NoticeInfo> getNoticeList(int beginIndex, int length) {
		List<Notice> notices =  noticeDao.getNoticeList(beginIndex,length);
		if (notices != null && notices.size() > 0){
			List<NoticeInfo> noticeInfos = new ArrayList<NoticeInfo>();
			for(Notice notice: notices){
				NoticeInfo noticeInfo = new NoticeInfo();
				noticeInfo.setNoticecontent(notice.getNoticecontent());
				noticeInfo.setNoticeid(notice.getNoticeid());
				noticeInfo.setNoticetitle(notice.getNoticetitle());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String postTimeString = sdf.format(notice.getPosttime().getTime());
				noticeInfo.setPosttime(postTimeString);
				noticeInfos.add(noticeInfo);
			}
			return noticeInfos;
		}else{
			return null;
		}
	}

	@Override
	public int getNoticeCount() {
		return noticeDao.getNoticeCount();
	}

}
