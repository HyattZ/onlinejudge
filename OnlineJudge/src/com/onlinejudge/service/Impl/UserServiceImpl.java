package com.onlinejudge.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.ProblemDao;
import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.dao.ScoreDao;
import com.onlinejudge.dao.SubmitTimesDao;
import com.onlinejudge.dao.UserDao;
import com.onlinejudge.dao.WeekScoreDao;
import com.onlinejudge.dao.impl.WeeklyScoreDaoImpl;
import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.domain.RankListItemInfo;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.domain.database.Score;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.domain.database.WeeklyScore;
import com.onlinejudge.dto.UpdatePasswordFormBean;
import com.onlinejudge.dto.UpdateUserFormBean;
import com.onlinejudge.service.UserService;
import com.onlinejudge.tool.ConfigsOperator;
import com.onlinejudge.tool.MD5;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Component("userServiceImpl")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private ScoreDao scoreDao;
	private WeekScoreDao weekScoreDao;
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

	public RecordDao getRecordDao() {
		return recordDao;
	}
	@Resource(name="recordDaoImpl")
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public ProblemDao getProblemDao() {
		return problemDao;
	}
	@Resource(name="problemDaoImpl")
	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ScoreDao getScoreDao() {
		return scoreDao;
	}
	@Resource(name = "scoreDaoImpl")
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	public WeekScoreDao getWeekScoreDao() {
		return weekScoreDao;
	}
	@Resource(name="weeklyScoreDaoImpl")
	public void setWeekScoreDao(WeekScoreDao weekScoreDao) {
		this.weekScoreDao = weekScoreDao;
	}

	@Override
	public LinkedHashMap<String, User> getUserMap(int length, int beginIndex) {
		LinkedHashMap<String, User> users = new LinkedHashMap<String, User>();
		List<User> usersList = userDao.getUserRankList(length, beginIndex);

		for (int i = beginIndex; i < beginIndex + length; i++) {
			users.put((i - beginIndex) + "", usersList.get(i - beginIndex));
		}

		return users;
	}

	@Override
	public String getPasswordByUserName(String userName) {
		return userDao.getPasswordByUserName(userName);
	}

	@Override
	public boolean saveUser(User u) {
		return userDao.saveUser(u);
	}

	@Override
	public boolean checkUsername(String userName) {
		return userDao.existUsername(userName);
	}

	@Override
	public boolean checkStuId(int stuid) {
		return userDao.isStuIdAvailable(stuid);
	}

	@Override
	public List<RankListItemInfo> getUserList(int length, int beginIndex) {
		List<User> users = userDao.getUserRankList(length, beginIndex);
		if (users != null && users.size() > 0) {
			List<RankListItemInfo> rankListItems = new ArrayList<RankListItemInfo>();
			
			for (User u : users) {
				RankListItemInfo rankListItem = new RankListItemInfo();
				rankListItem.setScore(u.getScore().getScore());
				rankListItem.setUsername(u.getUsername());				
				System.out.println(rankListItem);
				rankListItems.add(rankListItem);
			}

			return rankListItems;
		} else {
			return null;
		}
	}

	@Override
	public InformationPanelUserInfo getIPUserInformation(int stuid) {
		return userDao.getIPUserInformation(stuid);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public boolean checkEmail(String email) {
		return userDao.isEmailAvailable(email);
	}

	@Override
	public List<RankListItemInfo> getUserWeeklyScoreList(int length,
			int beginIndex) {
		List<User> users = userDao.getUserWeeklyScoreList(length, beginIndex);
		if (users != null && users.size() > 0) {
			List<RankListItemInfo> rankListItems = new ArrayList<RankListItemInfo>();
			for (User u : users) {
				RankListItemInfo rankListItem = new RankListItemInfo();
				rankListItem.setScore(u.getWeeklyScore().getScore());
				rankListItem.setUsername(u.getUsername());
				rankListItems.add(rankListItem);
			}
			return rankListItems;
		} else {
			return null;
		}
	}
	
	@Override
	public User init(User u) {
		//如果Score和weekScore有一个为空则对其进行初始化
		Score score = u.getScore();
		if (score == null){
			score = new Score();
			score.setStuid(u.getStuid());
			score.setScore(0);
			u.setScore(score);
			scoreDao.save(score);
		}
		
		WeeklyScore weeklyScore = u.getWeeklyScore();
		if (weeklyScore == null){
			weeklyScore = new WeeklyScore();
			weeklyScore.setStuid(u.getStuid());
			weeklyScore.setScore(0);
			u.setWeeklyScore(weeklyScore);
			weekScoreDao.saveWeeklyScore(weeklyScore);
		}
		
		//判断如果是新的一天则把数据库里面未完成的题目剩余次数置为20
		try {
			int currentRound = -1;
			ConfigsOperator co = new ConfigsOperator();
			String currentRoundString = co.getProperties("currentRound");
			currentRound = Integer.parseInt(currentRoundString);
			List<Integer> problemIds = problemDao.getProblemIdsByRound(currentRound);
			
			for (Integer problemId:problemIds){
				int times = submitTimesDao.getTimes(u.getStuid(), problemId);
				Date date = submitTimesDao.getRecordDate(u.getStuid(), problemId);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = sdf.format(new Date());
				Date currentDate = sdf.parse(dateString);
				if (date.before(currentDate) && !recordDao.isRecordExists(problemId+"-"+u.getStuid())){
						//如果题目没有完成并且数据库里面的时间比当前时间早，则将其剩余次数改变为20
						submitTimesDao.updateSubmitTimes(u.getStuid(), problemId);	
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public String getPasswordByEmail(String email) {
		return userDao.getPasswordByEmail(email);
	}

	@Override
	public boolean updateUser(UpdateUserFormBean uufb,String email) {
		try{
			User u = userDao.getUserByEmail(email);
			u.setPhonenum(uufb.getPhonenum());
			u.setUsername(uufb.getUsername());
			u.setRealname(uufb.getRealname());
			u.setQq(uufb.getQq());
			
			return userDao.updateUser(u);
			
		}catch(Exception e){
			return false;
		}
		
	}

	
	@Override
	public boolean updateUser(UpdatePasswordFormBean upfb, String email) {
		try{
			User u = userDao.getUserByEmail(email);
			u.setPassword(MD5.GetMD5Code(upfb.getPassword()));
			return userDao.updateUser(u);
			
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public int getUserScoreCount() {
		return userDao.getUserScoreCount();
	}

	@Override
	public int getUserWeeklyScoreCount() {
		return userDao.getUseWeeklyrScoreCount();
	}
	
}
