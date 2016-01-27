package com.onlinejudge.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.annotation.AccessToUrl;
import com.onlinejudge.constant.Status;
import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.dto.FlagFormBean;
import com.onlinejudge.enums.IsLogin;
import com.onlinejudge.service.ProblemService;
import com.onlinejudge.service.RecordService;
import com.onlinejudge.service.ScoreService;
import com.onlinejudge.service.SubmitTimesService;
import com.onlinejudge.service.WeeklyScoreService;
import com.onlinejudge.tool.ConfigsOperator;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */

@Component("flagAction")
public class FlagAction implements ModelDriven, SessionAware {
	private FlagFormBean flagFormBean;
	private ProblemService problemService;
	private ScoreService scoreService;
	private Map<String, Object> session;
	private SubmitTimesService submitTimesService;
	private RecordService recordService;
	private WeeklyScoreService weeklyScoreService;
	private Logger logger = Logger.getLogger(this.getClass());

	public FlagFormBean getFlagFormBean() {
		return flagFormBean;
	}

	@Resource(name = "flagFormBean")
	public void setFlagFormBean(FlagFormBean flagFormBean) {
		this.flagFormBean = flagFormBean;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

	@Resource(name = "scoreServiceImpl")
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public ProblemService getProblemService() {
		return problemService;
	}

	@Resource(name = "problemServiceImpl")
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}

	public SubmitTimesService getSubmitTimesService() {
		return submitTimesService;
	}

	@Resource(name = "submitTimesServiceImpl")
	public void setSubmitTimesService(SubmitTimesService submitTimesService) {
		this.submitTimesService = submitTimesService;
	}

	public RecordService getRecordService() {
		return recordService;
	}

	@Resource(name = "recordServiceImpl")
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}

	public WeeklyScoreService getWeeklyScoreService() {
		return weeklyScoreService;
	}

	@Resource(name = "weeklyScoreServiceImpl")
	public void setWeeklyScoreService(WeeklyScoreService weeklyScoreService) {
		this.weeklyScoreService = weeklyScoreService;
	}

	@Override
	public Object getModel() {
		return flagFormBean;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@AccessToUrl(IsLogin.YES)
	public String checkFlag(){
		try {
			// 先验证数据是否非法
			if (flagFormBean.validateFlag() && flagFormBean.validateProblemid()) {
				// 如果数据不非法
				Problem problem = problemService
						.getProblemByProblemid(flagFormBean.getProblemid());
				ConfigsOperator co = new ConfigsOperator();
				if (problem != null
						&& problem.getRound() == Integer.parseInt(co
								.getProperties("currentRound"))) {

					// 判断这道题目是不是已经做过
					if (!recordService.isComplete(
							(Integer) session.get("stuid"),
							flagFormBean.getProblemid())) {

						// 判断题目今天是否还有做的机会
						if (submitTimesService.checkSubmittimes(
								(Integer) session.get("stuid"),
								flagFormBean.getProblemid())) {

							// 判断题目是否正确
							if (problem.getFlag().trim()
									.equals(flagFormBean.getFlag().trim())) {
								session.put("successMessage", "恭喜完成题目！");
								session.put("successPageTitle", "答案正确！");
								// 题目正确对总榜进行更新
								boolean flag = scoreService.updateScore(
										(Integer) session.get("stuid"),
										problem.getMark());

								// 题目正确对周榜进行更新
								boolean flag0 = weeklyScoreService.updateScore(
										(Integer) session.get("stuid"),
										problem.getMark());

								if (!flag) {
									// 往数据库里面写入数据出错
									session.put("errorReason", "写入数据库出错，请再次提交！");
									session.put("errorPageTitle", "系统错误");

									logger.info("Stuid ["
											+ session.get("stuid") + "]"
											+ ";SubmitInfo ["
											+ flagFormBean.toString() + "]"
											+ ";Result[" + false + "]");
									return Status.UPDATEFAIL;
								} else {
									// 如果成功将结果存入数据库，1.则当天的次数减点一次,
									// 2.并且将record存入数据库

									if (!recordService.saveRecord(
											(Integer) session.get("stuid"),
											flagFormBean.getProblemid(),
											flagFormBean.getFlag())) {
										session.put("errorReason",
												"写入数据库出错，请再次提交！");
										session.put("errorPageTitle", "系统错误");
										logger.info("Stuid ["
												+ session.get("stuid") + "]"
												+ ";SubmitInfo ["
												+ flagFormBean.toString() + "]"
												+ ";Result[" + false + "]");
										return Status.UPDATEFAIL;
									}

									getSubmitTimesService().subTimes(
											(Integer) session.get("stuid"),
											flagFormBean.getProblemid());
								}
								logger.info("Stuid [" + session.get("stuid")
										+ "]" + ";SubmitInfo ["
										+ flagFormBean.toString() + "]"
										+ ";Result[" + true + "]");
								return Status.SUCCESS;

							} else {
								session.put("errorReason", "很遗憾，答案错误！");
								session.put("errorPageTitle", "答案错误");
								getSubmitTimesService().subTimes(
										(Integer) session.get("stuid"),
										flagFormBean.getProblemid());
								logger.info("Stuid [" + session.get("stuid")
										+ "]" + ";SubmitInfo ["
										+ flagFormBean.toString() + "]"
										+ ";Result[" + false + "]");
								return Status.FLAGERROR;
							}
						} else {
							session.put("errorReason", "您今天已经没有机会做这道题了！");
							session.put("errorPageTitle", "次数用完");
							logger.info("Stuid [" + session.get("stuid") + "]"
									+ ";SubmitInfo [" + flagFormBean.toString()
									+ "]" + ";Result[" + false + "]");
							return Status.NOCHANCE;
						}
					} else {
						session.put("errorReason", "题目已完成！");
						session.put("errorPageTitle", "题目完成");
						logger.info("Stuid [" + session.get("stuid") + "]"
								+ ";SubmitInfo [" + flagFormBean.toString()
								+ "]" + ";Result[" + false + "]");
						return Status.NOCHANCE;
					}
				} else {
					session.put("errorReason", "不是本轮的题目不能提交！");
					logger.info("Stuid [" + session.get("stuid") + "]"
							+ ";SubmitInfo [" + flagFormBean.toString() + "]"
							+ ";Result[" + false + "]");
					return Status.NOCHANCE;
				}
			} else {
				session.put("errorReason", "flag参数非法");
				session.put("errorPageTitle", "参数非法");
				logger.info("Stuid [" + session.get("stuid") + "]"
						+ ";SubmitInfo [" + flagFormBean.toString() + "]"
						+ ";Result[" + false + "]");
				return Status.FAIL;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.put("errorReason", "网络异常！");
			session.put("errorPageTitle", "异常");
			return Status.FAIL;
		}
	}
}
