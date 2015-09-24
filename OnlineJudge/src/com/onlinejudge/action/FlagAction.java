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
 * @author ��Ц��
 *
 * @time 2015��9��22��
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
				session.put("successMessage","��ϲ�����Ŀ��");
				session.put("successPageTitle", "����ȷ��");
				
				//�����Ŀ֮��Ҫ�����ݽ��и���
				
				//���ܰ���и���
				boolean flag = scoreService.updateScore((Integer)session.get("stuid"),problem.getMark());
				if (!flag){
					session.put("errorReason", "д�����ݿ�������ٴ��ύ��");
					session.put("errorPageTitle", "ϵͳ����");
					return Status.UPDATEFAIL;
				}
				
				return Status.SUCCESS;
			}else{
				session.put("errorReason", "���ź����𰸴���");
				session.put("errorPageTitle", "�𰸴���");
				return Status.FLAGERROR;
			}
		}else{
			session.put("errorReason", "flag�����Ƿ�");
			session.put("errorPageTitle", "�����Ƿ�");
			return Status.FAIL;
		}
	}

}
