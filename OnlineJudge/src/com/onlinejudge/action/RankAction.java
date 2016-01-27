package com.onlinejudge.action;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

















import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.domain.database.WeeklyScore;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.UserService;
import com.onlinejudge.service.WeeklyScoreService;
import com.onlinejudge.tool.ConfigsOperator;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */

@Component
public class RankAction implements ServletRequestAware{
	
	private Logger logger = Logger.getLogger(RankAction.class);
	private UserService userService;
	private WeeklyScoreService weeklyScoreService;
	private HttpServletRequest request;
	private int rankPage;
	private int weeklyRankPage;
	private String result;


	public int getWeeklyRankPage() {
		return weeklyRankPage;
	}

	public void setWeeklyRankPage(String weeklyRankPageString) {
		try{
			this.weeklyRankPage = Integer.parseInt(weeklyRankPageString);
			if (this.weeklyRankPage < 1){
				this.weeklyRankPage = 1;
			}
		}catch(Exception e){
			this.weeklyRankPage = 1 ;
		}
	}

	public int getRankPage() {
		return rankPage;
	}

	public void setRankPage(String rankPageString) {
		try{
			this.rankPage = Integer.parseInt(rankPageString);
			if (this.rankPage < 1){
				this.rankPage = 1;
			}
		}catch(Exception e){
			this.rankPage = 1 ;
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public WeeklyScoreService getWeeklyScoreService() {
		return weeklyScoreService;
	}
	@Resource(name="weeklyScoreServiceImpl")
	public void setWeeklyScoreService(WeeklyScoreService weeklyScoreService) {
		this.weeklyScoreService = weeklyScoreService;
	}
	
	public String getRank(){
		try{
			
			JSONArray jsonArray = new JSONArray();
			int userCount = userService.getUserScoreCount();
			int maxPage = userCount / 5;
			if (userCount % 5 > 0){
				maxPage ++;
			}
			if (maxPage > 8){
				maxPage = 8;
			}
			if (rankPage <= maxPage ){
				jsonArray.addAll(userService.getUserList(5, (rankPage-1)*5));
				long[] indexs = new long[2];
				indexs = getIndexs(userCount,5);
				JSONObject json = new JSONObject();
				json.accumulate("scores", jsonArray);
				if (indexs[1] > 8){
					indexs[1] = 8;
					indexs[0] = 4;
				}
				json.accumulate("rankBeginIndex", indexs[0]);
				json.accumulate("rankEndIndex", indexs[1]);
				json.accumulate("rankMaxPage", maxPage);
				json.accumulate("rankPage", rankPage);
				result = json.toString();
			}else{
				result="";
			}
			return Status.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("��ȡ���а�ʧ�ܣ�ԭ��"+e.getMessage());
			return Status.FAIL;
		}
	}
	
	public String getWeeklyRank() throws Exception{
		
		if (!dealRecordRound()){
			//�������ͬһ��Ҫ�����ݿ���и��£�ȫ���ķ�������
			weeklyScoreService.setAllScoreToZero();
		}
		
		try{
			JSONArray jsonArray = new JSONArray();
			int userCount =  userService.getUserWeeklyScoreCount();
			int maxPage = userCount / 5;
			if (userCount % 5 > 0){
				maxPage ++;
			}
			if (maxPage > 8){
				maxPage = 8;
			}
			if (weeklyRankPage <= maxPage ){
				jsonArray.addAll(userService.getUserWeeklyScoreList(5,(weeklyRankPage-1)*5));
				long[] indexs = new long[2];
				indexs = getWeeklyIndexs(userCount,5);
				JSONObject json = new JSONObject();
				json.accumulate("Weeklyscores", jsonArray);
				if (indexs[1] > 8){
					indexs[1] = 8;
					indexs[0] = 4;
				}
				json.accumulate("weeklyRankBeginIndex", indexs[0]);
				json.accumulate("weeklyRankEndIndex", indexs[1]);
				json.accumulate("weekRankMaxPage", maxPage);
				json.accumulate("weeklyRankPage", weeklyRankPage);
				result = json.toString();
			}else{
				result = "";
			}
			return Status.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("��ȡ���а�ʧ�ܣ�ԭ��"+e.getMessage());
			return Status.FAIL;
		}
		
	}
	
	/**
	 * 
	 *@return true
	 *						�����ڵ���ͬһ����
	 *					false
	 *						ԭ���ļ��е����ݺ͵�ǰ����ͬһ���ܣ������޸�֮����ͬһ����
	 * 
	 * */
	private boolean dealRecordWeek() throws Exception{
		ConfigsOperator operator = new ConfigsOperator();
		String recordWeek = operator.getProperties("recordWeek");
		Calendar cal = Calendar.getInstance();
		String currentWeek = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.WEEK_OF_YEAR);
		
		if (!currentWeek.equals(recordWeek)){
			operator.saveProperties("recordWeek",currentWeek);
			return false;
		}
		return true;
	}
	
	private boolean dealRecordRound() throws Exception{
		ConfigsOperator operator = new ConfigsOperator();
		String recordRound = operator.getProperties("recordRound");
		String currentRound = operator.getProperties("currentRound");
		if (recordRound.equals(currentRound)){
			//�����¼�������͵�ǰ��һ����
			return true;
		}else{
			operator.saveProperties("recordRound", currentRound);
			return false;
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
			if ((maxIndex - rankPage) < length) {
				indexs[0] = maxIndex - length + 1;
			} else {
				indexs[0] = rankPage;
			}

			// ���ý���������
			if ((maxIndex - rankPage) < length) {
				indexs[1] = maxIndex;
			} else {
				indexs[1] = rankPage + length - 1;
			}
		}
		return indexs;
	}
	
	public long[] getWeeklyIndexs(long count, long length) {
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
			if ((maxIndex - weeklyRankPage) < length) {
				indexs[0] = maxIndex - length + 1;
			} else {
				indexs[0] = weeklyRankPage;
			}

			// ���ý���������
			if ((maxIndex - weeklyRankPage) < length) {
				indexs[1] = maxIndex;
			} else {
				indexs[1] = weeklyRankPage + length - 1;
			}
		}
		return indexs;
	}
	
}
