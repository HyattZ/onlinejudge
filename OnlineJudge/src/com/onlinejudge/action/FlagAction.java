package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.dto.FlagFormBean;
import com.onlinejudge.service.ProblemService;
import com.onlinejudge.service.ScoreService;
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
	private ScoreService scoreService;
	private Map<String,Object> session;

	public FlagFormBean getFlagFormBean() {
		return flagFormBean;
	}
	@Resource(name="flagFormBean")
	public void setFlagFormBean(FlagFormBean flagFormBean) {
		this.flagFormBean = flagFormBean;
	}
	
	public ScoreService getScoreService() {
		return scoreService;
	}
	@Resource(name="scoreServiceImpl")
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
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
			Problem problem = problemService.getProblemByProblemid(flagFormBean.getProblemid());
			if (problem.getFlag().trim().equals(flagFormBean.getFlag().trim())){
				session.put("successMessage","恭喜完成题目！");
				session.put("successPageTitle", "答案正确！");
				
				//答对题目之后要对数据进行更新
				
				//对总榜进行更新
				boolean flag = scoreService.updateScore((Integer)session.get("stuid"),problem.getMark());
				if (!flag){
					session.put("errorReason", "写入数据库出错，请再次提交！");
					session.put("errorPageTitle", "系统错误");
					return Status.UPDATEFAIL;
				}
				
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
