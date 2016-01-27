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
 * @author ��Ц��
 *
 * @time 2015��9��22��
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
			// ����֤�����Ƿ�Ƿ�
			if (flagFormBean.validateFlag() && flagFormBean.validateProblemid()) {
				// ������ݲ��Ƿ�
				Problem problem = problemService
						.getProblemByProblemid(flagFormBean.getProblemid());
				ConfigsOperator co = new ConfigsOperator();
				if (problem != null
						&& problem.getRound() == Integer.parseInt(co
								.getProperties("currentRound"))) {

					// �ж������Ŀ�ǲ����Ѿ�����
					if (!recordService.isComplete(
							(Integer) session.get("stuid"),
							flagFormBean.getProblemid())) {

						// �ж���Ŀ�����Ƿ������Ļ���
						if (submitTimesService.checkSubmittimes(
								(Integer) session.get("stuid"),
								flagFormBean.getProblemid())) {

							// �ж���Ŀ�Ƿ���ȷ
							if (problem.getFlag().trim()
									.equals(flagFormBean.getFlag().trim())) {
								session.put("successMessage", "��ϲ�����Ŀ��");
								session.put("successPageTitle", "����ȷ��");
								// ��Ŀ��ȷ���ܰ���и���
								boolean flag = scoreService.updateScore(
										(Integer) session.get("stuid"),
										problem.getMark());

								// ��Ŀ��ȷ���ܰ���и���
								boolean flag0 = weeklyScoreService.updateScore(
										(Integer) session.get("stuid"),
										problem.getMark());

								if (!flag) {
									// �����ݿ�����д�����ݳ���
									session.put("errorReason", "д�����ݿ�������ٴ��ύ��");
									session.put("errorPageTitle", "ϵͳ����");

									logger.info("Stuid ["
											+ session.get("stuid") + "]"
											+ ";SubmitInfo ["
											+ flagFormBean.toString() + "]"
											+ ";Result[" + false + "]");
									return Status.UPDATEFAIL;
								} else {
									// ����ɹ�������������ݿ⣬1.����Ĵ�������һ��,
									// 2.���ҽ�record�������ݿ�

									if (!recordService.saveRecord(
											(Integer) session.get("stuid"),
											flagFormBean.getProblemid(),
											flagFormBean.getFlag())) {
										session.put("errorReason",
												"д�����ݿ�������ٴ��ύ��");
										session.put("errorPageTitle", "ϵͳ����");
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
								session.put("errorReason", "���ź����𰸴���");
								session.put("errorPageTitle", "�𰸴���");
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
							session.put("errorReason", "�������Ѿ�û�л�����������ˣ�");
							session.put("errorPageTitle", "��������");
							logger.info("Stuid [" + session.get("stuid") + "]"
									+ ";SubmitInfo [" + flagFormBean.toString()
									+ "]" + ";Result[" + false + "]");
							return Status.NOCHANCE;
						}
					} else {
						session.put("errorReason", "��Ŀ����ɣ�");
						session.put("errorPageTitle", "��Ŀ���");
						logger.info("Stuid [" + session.get("stuid") + "]"
								+ ";SubmitInfo [" + flagFormBean.toString()
								+ "]" + ";Result[" + false + "]");
						return Status.NOCHANCE;
					}
				} else {
					session.put("errorReason", "���Ǳ��ֵ���Ŀ�����ύ��");
					logger.info("Stuid [" + session.get("stuid") + "]"
							+ ";SubmitInfo [" + flagFormBean.toString() + "]"
							+ ";Result[" + false + "]");
					return Status.NOCHANCE;
				}
			} else {
				session.put("errorReason", "flag�����Ƿ�");
				session.put("errorPageTitle", "�����Ƿ�");
				logger.info("Stuid [" + session.get("stuid") + "]"
						+ ";SubmitInfo [" + flagFormBean.toString() + "]"
						+ ";Result[" + false + "]");
				return Status.FAIL;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.put("errorReason", "�����쳣��");
			session.put("errorPageTitle", "�쳣");
			return Status.FAIL;
		}
	}
}
