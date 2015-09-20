package com.onlinejudge.service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.UserDao;
import com.onlinejudge.domain.User;
import com.onlinejudge.service.UserService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public LinkedHashMap<String, User> getUserMap(int length,int beginIndex){
		LinkedHashMap<String,User> users = new LinkedHashMap<String,User>();
		List<User> usersList = userDao.getUserRankList(length, beginIndex);
		 
		for (int i = beginIndex ; i< beginIndex+length; i++){
			users.put((i-beginIndex)+"", usersList.get(i-beginIndex));
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
	public List<User> getUserList(int length, int beginIndex) {
		return userDao.getUserRankList(length, beginIndex);
	}
}
