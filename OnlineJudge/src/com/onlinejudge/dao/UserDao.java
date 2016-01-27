package com.onlinejudge.dao;

import java.util.List;

import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.domain.database.WeeklyScore;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public interface UserDao {

	public abstract List<User> getUserRankList(int length, int beginIndex);

	public abstract boolean saveUser(User u);
	
	public abstract String getPasswordByUserName(String userName);

	public abstract boolean existUsername(String userName);

	public abstract boolean isStuIdAvailable(int stuid);
	
	public abstract InformationPanelUserInfo getIPUserInformation(int stuid);

	public abstract User getUserByUsername(String username);

	public abstract boolean isEmailAvailable(String email);

	public abstract List<User> getUserWeeklyScoreList(int length,
			int beginIndex);

	public abstract User getUserByEmail(String email);
	
	public abstract String getPasswordByEmail(String email);

	public abstract boolean updateUser(User u);

	public abstract int getUserScoreCount();

	public abstract int getUseWeeklyrScoreCount();


}