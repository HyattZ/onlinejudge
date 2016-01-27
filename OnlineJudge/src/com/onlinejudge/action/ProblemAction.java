package com.onlinejudge.action;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.onlinejudge.annotation.PermissionCheck;
import com.onlinejudge.constant.Status;
import com.onlinejudge.dto.ProblemFormBean;
import com.onlinejudge.enums.Permission;
import com.onlinejudge.service.ProblemService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 赵笑天
 *
 * @time 2015年9月28日
 * 
 */
public class ProblemAction implements ModelDriven{
	private ProblemService problemService;
	private ProblemFormBean problemFormBean;
	private String result;

	public ProblemService getProblemService() {
		return problemService;
	}
	@Resource(name="problemServiceImpl")
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}

	@Override
	public Object getModel() {
		return getProblemFormBean();
	}
	
	@PermissionCheck(Permission.Administrator)
	public String addProblem(){
		JSONObject json = new JSONObject();
		if(getProblemFormBean().validatePFB()){		
			boolean status = problemService.addProblem(getProblemFormBean());
			if (status){
				json.accumulate("status", status);
				System.out.println(json.toString());
				result = json.toString();
				return Status.SUCCESS;
			}
			json.accumulate("status", status);
			result = json.toString();
			return Status.FAIL;
		}else{
			json.accumulate("status", false);
			result = json.toString();
			return Status.FAIL;
		}
	}
	public ProblemFormBean getProblemFormBean() {
		return problemFormBean;
	}
	@Resource(name = "problemFormBean")
	public void setProblemFormBean(ProblemFormBean problemFormBean) {
		this.problemFormBean = problemFormBean;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
