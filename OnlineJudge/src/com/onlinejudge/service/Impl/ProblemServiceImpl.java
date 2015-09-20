package com.onlinejudge.service.Impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.ProblemDao;
import com.onlinejudge.dao.UserDao;
import com.onlinejudge.domain.Problem;
import com.onlinejudge.dto.ResultFormBean;
import com.onlinejudge.service.ProblemService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
@Component("problemServiceImpl")
public class ProblemServiceImpl implements ProblemService{
	
	private ProblemDao problemDao;
	
	public ProblemDao getProblemDao() {
		return problemDao;
	}
	@Resource(name="")
	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	@Override
	public List<Problem> getProblemList(int length,int beginIndex) {
		
		return problemDao.getProblemList(length, beginIndex);
	}
	
	@Override
	public boolean checkResult(ResultFormBean rfb) {
		String flag = problemDao.getFlagById(rfb.getProblemid());
		if (flag != null && flag.equals(rfb.getFlag())){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public long getProblemCount() {
		
		return problemDao.getProblemCount();
	}

	

}
