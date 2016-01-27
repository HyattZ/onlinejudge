package com.onlinejudge.service;

import java.util.List;
import java.util.Map;

import com.onlinejudge.domain.ProblemAnswerPageInfo;
import com.onlinejudge.domain.ProblemListItem;
import com.onlinejudge.domain.SubmitPageProblemInfo;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.dto.ProblemFormBean;
import com.onlinejudge.dto.ResultFormBean;


/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
public interface ProblemService {
	public abstract List<ProblemListItem> getProblemList(int length, int beginIndex
			,Map<String,Object> session);

	public abstract boolean checkResult(ResultFormBean rfb);

	public abstract long getProblemCount();

	public abstract SubmitPageProblemInfo getSFPProblem(int id);

	public abstract String getFlagByProblemid(int problemid);

	public abstract Problem getProblemByProblemid(int problemid);

	public abstract boolean addProblem(ProblemFormBean problemFormBean);
	
	public abstract int getWeekNum();

	public abstract List<ProblemAnswerPageInfo> getProblemIdsByWeek(int week);

	public abstract List<ProblemListItem> getProblemListByRound(int currentRound,Map<String,Object> session);
}
