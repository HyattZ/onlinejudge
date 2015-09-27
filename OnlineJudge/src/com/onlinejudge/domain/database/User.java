package com.onlinejudge.domain.database;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.engine.CascadeStyle;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Entity
@Table(name="user")
public class User {
	private int stuid;
	private String username;
	private String password;
	private String realname;
	private String qq;
	private String phonenum;
	private String email;
	private String faviconuri;
	private Set<Record> records;
	private Score score;
	private Set<SubmitTime> submittimes;
	private WeeklyScore weeklyScore;
	
	public User(){
		
	}
	
	public String getEmail() {
		return email;
	}

	public String getFaviconuri() {
		return faviconuri;
	}

	public String getPassword() {
		return password;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public String getQq() {
		return qq;
	}
	@Id
	public int getStuid() {
		return stuid;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFaviconuri(String faviconuri) {
		this.faviconuri = faviconuri;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@OneToMany
	@JoinColumn(name="stuid")
	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}
	@OneToMany
	@JoinColumn(name="stuid")
	public Set<SubmitTime> getSubmittimes() {
		return submittimes;
	}

	public void setSubmittimes(Set<SubmitTime> submittimes) {
		this.submittimes = submittimes;
	}

	@OneToOne
	@JoinColumn(name="stuid")
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	@OneToOne
	@JoinColumn(name="stuid")
	public WeeklyScore getWeeklyScore() {
		return weeklyScore;
	}

	public void setWeeklyScore(WeeklyScore weeklyScore) {
		this.weeklyScore = weeklyScore;
	}

	@Override
	public String toString() {
		return "User [stuid=" + stuid + ", username=" + username
				+ ", password=" + password + ", realname=" + realname + ", qq="
				+ qq + ", phonenum=" + phonenum + ", email=" + email
				+ ", faviconuri=" + faviconuri + ", score=" + score
				+ ", submittimes=" + submittimes + ", weeklyScore="
				+ weeklyScore + "]";
	}


}
