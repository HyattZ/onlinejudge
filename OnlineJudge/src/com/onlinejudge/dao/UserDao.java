package com.onlinejudge.dao;

import java.util.List;

import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.domain.database.User;

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

}