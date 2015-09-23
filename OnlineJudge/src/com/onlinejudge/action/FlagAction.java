package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.dto.FlagFormBean;
import com.onlinejudge.service.ProblemService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
public class FlagAction implements ModelDriven,SessionAware{
	private FlagFormBean flagFormBean;
	private ProblemService problemService;
	private Map<String,Object> session;

	public FlagFormBean getFlagFormBean() {
		return flagFormBean;
	}
	@Resource(name="flagFormBean")
	public void setFlagFormBean(FlagFormBean flagFormBean) {
		this.flagFormBean = flagFormBean;
	}
	
	public ProblemService getProblemService() {
		return problemService;
	}
	@Resource(name="problemServiceImpl")
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@Override
	public Object getModel() {
		return flagFormBean;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String checkFlag(){
		if (flagFormBean.validateFlag() && flagFormBean.validateProblemid()){
			String flag = problemService.getFlagByProblemid(flagFormBean.getProblemid());
			if (flag.trim().equals(flagFormBean.getFlag().trim())){
				session.put("successMessage","恭喜完成题目！");
				session.put("successPageTitle", "答案正确！");
				return Status.SUCCESS;
			}else{
				session.put("errorReason", "很遗憾，答案错误！");
				session.put("errorPageTitle", "答案错误");
				return Status.FLAGERROR;
			}
		}else{
			session.put("errorReason", "flag参数非法");
			session.put("errorPageTitle", "参数非法");
			return Status.FAIL;
		}
	}

}
