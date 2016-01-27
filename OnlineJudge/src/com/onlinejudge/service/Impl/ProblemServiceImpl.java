package com.onlinejudge.service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.ProblemDao;
import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.dao.SubmitTimesDao;
import com.onlinejudge.dao.UserDao;
import com.onlinejudge.domain.ProblemAnswerPageInfo;
import com.onlinejudge.domain.ProblemListItem;
import com.onlinejudge.domain.SubmitPageProblemInfo;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.dto.ProblemFormBean;
import com.onlinejudge.dto.ResultFormBean;
import com.onlinejudge.service.ProblemService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
@Component("problemServiceImpl")
public class ProblemServiceImpl implements ProblemService {

	private ProblemDao problemDao;
	private RecordDao recordDao;
	private SubmitTimesDao submitTimesDao;

	public SubmitTimesDao getSubmitTimesDao() {
		return submitTimesDao;
	}
	
	@Resource(name="submitTimesDaoImpl")
	public void setSubmitTimesDao(SubmitTimesDao submitTimesDao) {
		this.submitTimesDao = submitTimesDao;
	}

	public ProblemDao getProblemDao() {
		return problemDao;
	}

	@Resource(name = "")
	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	public RecordDao getRecordDao() {
		return recordDao;
	}

	@Resource(name = "recordDaoImpl")
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Override
	public List<ProblemListItem> getProblemList(int length, int beginIndex,
			Map<String,Object> session) {
		List<Problem> problems = problemDao.getProblemList(length, beginIndex);
		if (problems != null && problems.size() > 0) {
			List<ProblemListItem> problemListItems = new ArrayList<ProblemListItem>();
			if (session.get("stuid") != null) {
				// 如果是在登录状态
				for (Problem problem : problems) {
					ProblemListItem problemListItem = new ProblemListItem();
					problemListItem.setProblemid(problem.getProblemid());
					problemListItem.setMark(problem.getMark());
					problemListItem.setProblemtitle(problem.getProblemtitle());
					if (recordDao.isRecordExists(problem.getProblemid() + "-"
							+ (Integer)session.get("stuid"))) {
						//如果题目完成，剩余次数设置为-1
						problemListItem.setIsComplete(1);
						problemListItem.setSubmitTimes(-1);
					} else {
						problemListItem.setIsComplete(0);
						System.out.println(submitTimesDao.getTimes((Integer) session.get("stuid"), problem.getProblemid()));
						problemListItem.setSubmitTimes(submitTimesDao.getTimes((Integer) session.get("stuid"), problem.getProblemid()));
					}
					problemListItems.add(problemListItem);
				}
			} else {
				for (Problem problem : problems) {
					ProblemListItem problemListItem = new ProblemListItem();
					problemListItem.setProblemid(problem.getProblemid());
					problemListItem.setMark(problem.getMark());
					problemListItem.setProblemtitle(problem.getProblemtitle());
					problemListItem.setIsComplete(0);
					problemListItems.add(problemListItem);
				}
			}
			return problemListItems;
		} else {
			return null;
		}
	}

	@Override
	public boolean checkResult(ResultFormBean rfb) {
		String flag = problemDao.getFlagById(rfb.getProblemid());
		if (flag != null && flag.equals(rfb.getFlag())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public long getProblemCount() {

		return problemDao.getProblemCount();
	}

	@Override
	public SubmitPageProblemInfo getSFPProblem(int id) {
		return problemDao.getSFPProblem(id);
	}

	@Override
	public String getFlagByProblemid(int problemid) {
		return problemDao.getFlagById(problemid);
	}

	@Override
	public Problem getProblemByProblemid(int problemid) {
		return problemDao.getProblemByProblemid(problemid);
	}


	@Override
	public boolean addProblem(ProblemFormBean problemFormBean) {
		Problem problem = new Problem();
		problem.setMark(problemFormBean.getMark());
		problem.setFlag(problemFormBean.getFlag());
		problem.setProblemtitle(problemFormBean.getProblemtitle());
		problem.setProblemcontent(problemFormBean.getProblemcontent());
		problem.setRound(problemFormBean.getRound());
		return problemDao.saveProblem(problem);
	}
	
	@Override
	public int getWeekNum() {
		return problemDao.getWeekNum();
	}

	@Override
	public List<ProblemAnswerPageInfo> getProblemIdsByWeek(int week) {
		
		List<Problem> problems = problemDao.getProblmeIdsByWeek(week);
		if (problems != null && problems.size() >0){
			List<ProblemAnswerPageInfo> problemAnswerPageInfos = new ArrayList<ProblemAnswerPageInfo>();
			for (Problem problem:problems){
				ProblemAnswerPageInfo problemAnswerPageInfo = new ProblemAnswerPageInfo();
				problemAnswerPageInfo.setProblemid(problem.getProblemid());
				problemAnswerPageInfo.setProblemtitle(problem.getProblemtitle());
				problemAnswerPageInfos.add(problemAnswerPageInfo);
			}
			return problemAnswerPageInfos;
		}else{
			return null;
		}
	}
	
	@Override
	public List<ProblemListItem> getProblemListByRound(int currentRound,Map<String,Object> session) {
		List<Problem> problems = problemDao.getProblemListByRound(currentRound);
		if (problems != null && problems.size() > 0) {
			List<ProblemListItem> problemListItems = new ArrayList<ProblemListItem>();
			if (session.get("stuid") != null) {
				// 如果是在登录状态
				for (Problem problem : problems) {
					ProblemListItem problemListItem = new ProblemListItem();
					problemListItem.setProblemid(problem.getProblemid());
					problemListItem.setMark(problem.getMark());
					problemListItem.setProblemtitle(problem.getProblemtitle());
					if (recordDao.isRecordExists(problem.getProblemid() + "-"
							+ (Integer)session.get("stuid"))) {
						problemListItem.setIsComplete(1);
						problemListItem.setSubmitTimes(-1);					
					} else {
						problemListItem.setIsComplete(0);
						problemListItem.setSubmitTimes(submitTimesDao.getTimes((Integer) session.get("stuid"), problem.getProblemid()));
					}
					problemListItems.add(problemListItem);
				}
			} else {
				for (Problem problem : problems) {
					ProblemListItem problemListItem = new ProblemListItem();
					problemListItem.setProblemid(problem.getProblemid());
					problemListItem.setMark(problem.getMark());
					problemListItem.setProblemtitle(problem.getProblemtitle());
					problemListItem.setIsComplete(0);
					problemListItems.add(problemListItem);
				}
			}
			return problemListItems;
		} else {
			return null;
		}
	}

}
