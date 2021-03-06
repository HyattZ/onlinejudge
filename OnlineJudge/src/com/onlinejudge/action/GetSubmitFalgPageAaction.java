package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.SubmitPageProblemInfo;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.ProblemService;

/**
 * @author ��Ц��
 *
 * @time 2015��9��22��
 * 
 */

@Component("getSubmitFlagPageAction")
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
	
	@AccessToUrl(IsLogin.YES)
	public String getSubmitFlagPage(){
		SubmitPageProblemInfo sfp = problemService.getSFPProblem(getProblemid());
		request.put("sfp", sfp);
		return Status.SUCCESS;
	}
}
