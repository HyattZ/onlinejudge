package com.onlinejudge.service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlinejudge.dao.RecordDao;
import com.onlinejudge.dao.UserDao;
import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.domain.RankListItemInfo;
import com.onlinejudge.domain.database.User;
import com.onlinejudge.domain.database.WeeklyScore;
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
}
