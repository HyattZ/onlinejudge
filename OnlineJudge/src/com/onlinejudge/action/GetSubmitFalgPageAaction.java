package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.SubmitPageProblemInfo;
import com.onlinejudge.service.ProblemService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
public class GetSubmitFalgPageAaction implements RequestAware{
	
	private ProblemService problemService;
	private Map<String,Object> request;
	private int problemid;

	public int getProblemid() {
		if (problemid <= 0){
			problemid = 1;
		}
		return problemid;
	}

	public void setProblemid(int problemid) {
		this.problemid = problemid;
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
	
	public String getSubmitFlagPage(){
		SubmitPageProblemInfo sfp = problemService.getSFPProblem(getProblemid());
		request.put("sfp", sfp);
		return Status.SUCCESS;
	}
}
