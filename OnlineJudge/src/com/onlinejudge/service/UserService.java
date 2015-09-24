package com.onlinejudge.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.domain.database.User;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
public interface UserService{

	public abstract LinkedHashMap<String, User> getUserMap(int length, int beginIndex);
	
	public abstract List<User> getUserList(int length,int beginIndex);
	
	public abstract String getPasswordByUserName(String userName);

	public abstract boolean saveUser(User u);

	public abstract boolean checkUsername(String userName);

	public abstract boolean checkStuId(int stuid);

	public abstract InformationPanelUserInfo getIPUserInformation(int stuid);
	
	public abstract User getUserByUsername(String username);
	
	public abstract boolean checkEmail(String email);

}