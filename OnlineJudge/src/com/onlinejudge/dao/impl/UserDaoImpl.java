package com.onlinejudge.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.onlinejudge.dao.UserDao;
import com.onlinejudge.domain.InformationPanelUserInfo;
import com.onlinejudge.domain.database.Score;
import com.onlinejudge.domain.database.User;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;
	private Logger logger = Logger.getLogger(UserDaoImpl.class);

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<User> getUserRankList(int length,int beginIndex){
		List<User> users = new ArrayList<User>();
		
		users = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from User u order by u.score.score desc")
				.setMaxResults(length)
				.setFirstResult(beginIndex).list();
		
		hibernateTemplate.flush();
		
		return users;
	}
	
	@Override
	public boolean saveUser(User u){
		try{
			hibernateTemplate.save(u);
			return true;
		}catch(Exception e){
			logger.error("数据库出错:"+e.getMessage()+"!"+u+"未存入数据库！");
			return false;
		}
		
	}

	@Override
	public String getPasswordByUserName(String userName) {
		return (String) hibernateTemplate.getSessionFactory()
		.getCurrentSession()
		.createSQLQuery("select u.password from User u where u.username='"+userName+"'")
		.list().get(0);
	}
	
	/**
	 * 
	 * @param username	前台传过来的用户名
	 * @return false 数据库中已经存在该用户名
	 * 					true 数据库中不存在该用户名
	 * */
	@Override
	public boolean existUsername(String userName) {
		List list = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from User u where u.username ='"+userName+"'").list();
		
		if (list.isEmpty() && list.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean isStuIdAvailable(int stuid) {
		List list = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("from User u where u.stuid='"+stuid+"'").list();
		if (list.isEmpty() && list.size() == 0){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public InformationPanelUserInfo getIPUserInformation(int stuid) {
		List list = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createSQLQuery("select stuid,username,realname,qq,phonenum,email,faviconuri from User where stuid="+stuid)
				.list();
		System.out.println(list.size());
		if (list == null || list.size() ==0){
			return null;
		}else{
			InformationPanelUserInfo ipui= new InformationPanelUserInfo();
			Object[] obj = (Object[]) list.get(0);
			ipui.setUsername((String)obj[1]);
			ipui.setStuid((Integer)obj[0]);
			ipui.setQq((String)obj[3]);
			ipui.setPhonenum((String)obj[4]);
			ipui.setRealname((String)obj[2]);
			ipui.setEmail((String)obj[5]);
			ipui.setFaviconuri((String)obj[6]);
			return ipui;
		}
	}


	@Override
	public User getUserByUsername(String username) {
		
		List list =hibernateTemplate.getSessionFactory()
				.getCurrentSession()
				.createQuery("from User where username='"+username+"'")
				.list();
		if (list == null || list.size() == 0){
			return null;
		}else{
			User u = new User();
			u =(User) list.get(0);
			return u;
		}
	}


	@Override
	public boolean isEmailAvailable(String email) {
		
		List list = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("from User u where u.email='"+email+"'").list();
		if (list.isEmpty() && list.size() == 0){
			return true;
		}else{
			return false;
		}
	}
}
