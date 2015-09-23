package com.onlinejudge.service;

import java.util.List;

import com.onlinejudge.domain.SubmitPageProblemInfo;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.dto.ResultFormBean;


/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
public interface ProblemService {
	public abstract List<Problem> getProblemList(int length, int beginIndex);

	public abstract boolean checkResult(ResultFormBean rfb);

	public abstract long getProblemCount();

	public abstract SubmitPageProblemInfo getSFPProblem(int id);

	public abstract String getFlagByProblemid(int problemid);
}
