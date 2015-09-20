package com.onlinejudge.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.onlinejudge.domain.User;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */
public interface UserService{

	public abstract LinkedHashMap<String, User> getUserMap(int length, int beginIndex);
	
	public abstract List<User> getUserList(int length,int beginIndex);
	
	public abstract String getPasswordByUserName(String userName);

	public abstract boolean saveUser(User u);

	public abstract boolean checkUsername(String userName);

	public abstract boolean checkStuId(int stuid);

}