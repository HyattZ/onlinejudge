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
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */

@Component
public class RankAction implements ServletRequestAware{
	
	private Logger logger = Logger.getLogger(RankAction.class);
	private UserService userService;
	private WeeklyScoreService weeklyScoreService;
	private HttpServletRequest request;
	private String result;


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

			jsonArray.addAll(userService.getUserList(5, 0));
			JSONObject json = new JSONObject();
			json.accumulate("scores", jsonArray);
			result = json.toString();
			System.out.println(result);
			return Status.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("获取排行榜失败！原因："+e.getMessage());
			return Status.FAIL;
		}
	}
	
	public String getWeeklyRank() throws Exception{
		
		if (!dealRecordWeek()){
			//如果不是同一周要对数据库进行更新，全部的分数归零
			weeklyScoreService.setAllScoreToZero();
		}
		
		try{
			JSONArray jsonArray = new JSONArray();

			jsonArray.addAll(userService.getUserWeeklyScoreList(5,0));
			JSONObject json = new JSONObject();
			json.accumulate("Weeklyscores", jsonArray);
			result = json.toString();
			System.out.println(result);
			return Status.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("获取排行榜失败！原因："+e.getMessage());
			return Status.FAIL;
		}
		
	}
	
	/**
	 * 
	 *@return true
	 *						和现在的是同一个周
	 *					false
	 *						原本文件中的数据和当前不是同一个周，经过修改之后变成同一个周
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
}
