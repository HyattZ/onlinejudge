package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.dto.ResultFormBean;
import com.onlinejudge.service.ProblemService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 赵笑天
 *
 * @time 2015年9月17日
 * 
 */
public class CheckResultAction implements ModelDriven,SessionAware{
	private ResultFormBean rfb;
	private ProblemService problemService;
	private Map<String,Object> session;
	
	@Override
	public Object getModel() {
		return getRfb();
	}
	
	public ResultFormBean getRfb() {
		return rfb;
	}
	@Resource(name="resultFormBean")
	public void setRfb(ResultFormBean rfb) {
		this.rfb = rfb;
	}

	public ProblemService getProblemService() {
		return problemService;
	}
	
	@Resource(name="problemServiceImpl")
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
	
	public String checkResult(){
		if (getRfb().validateFlag() ){
			try{
				boolean flag = problemService.checkResult(getRfb());
				session.put("successMessage", "恭喜，答案正确！");
				session.put("successPageTitle","恭喜");
				return Status.SUCCESS;
			}catch(Exception e){
				e.printStackTrace();
				session.put("errorReason","数据库故障！" );
				return Status.FAIL;
			}
		}else{
			session.put("errorReason","参数不合法！" );
			return Status.FAIL;
		}
		
	}

	

}
