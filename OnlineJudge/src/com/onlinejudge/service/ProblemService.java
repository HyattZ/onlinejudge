package com.onlinejudge.service;

import java.util.List;

import com.onlinejudge.domain.Problem;
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
}
