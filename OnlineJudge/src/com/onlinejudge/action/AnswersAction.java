package com.onlinejudge.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.ProblemAnswerPageInfo;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.ProblemService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月30日
 * 
 */
public class AnswersAction implements RequestAware{
	private Map<String ,Object> request;
	private ProblemService problemService;
	private int problemid;
	
	public int getProblemid() {
		return problemid;
	}

	public void setProblemid(String problemidString) {
		try{
			this.problemid = Integer.parseInt(problemidString);
		}catch(NumberFormatException e){
			this.problemid = -1;
		}
	}
	
	public ProblemService getProblemService() {
		return problemService;
	}
	
	@Resource(name="problemServiceImpl")
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	/**
	 * 
	 * 获取总的周数，一共获取10周的数据，获取到最大的周数之后往前减10
	 * 获取每周的问题id数目显示
	 * 
	 * */
	public String showAnswers(){
		
		int weekNum = problemService.getWeekNum();
		int beginWeek = 0;
		
		if ( weekNum - 10 < 0){
			beginWeek = 1;
		}else{
			beginWeek = weekNum - 10;
		}
		
		request.put("beginWeek", beginWeek);
		request.put("weekNum", weekNum);
		
		Map<String,Object> problemIdMap = new LinkedHashMap<String,Object>();
		for (int i = beginWeek ; i <= weekNum ;i++){
			List<ProblemAnswerPageInfo> problemids = problemService.getProblemIdsByWeek(i);
			problemIdMap.put("week"+i, problemids);
		}
		
		request.put("problemIdMap", problemIdMap);
		
		return Status.SUCCESS;
	}
	
	@AccessToUrl(IsLogin.YES)
	public String showAnswer(){
		return Status.SUCCESS;
	}

	
}
