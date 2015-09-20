package com.onlinejudge.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private String nickname;
	private String qq;
	private String phonenum;
	private String email;
	private String faviconuri;
	private Set<Record> records;
	private Score score;
	
	public User(){
		
	}
	
	public String getEmail() {
		return email;
	}

	public String getFaviconuri() {
		return faviconuri;
	}

	public String getNickname() {
		return nickname;
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

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	@OneToOne
	@JoinColumn(name="stuid")
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "User [stuid=" + stuid + ", username=" + username
				+ ", password=" + password + ", nickname=" + nickname + ", qq="
				+ qq + ", phonenum=" + phonenum + ", email=" + email
				+ ", faviconuri=" + faviconuri + ", score=" + score.getScore() + "]";
	}

}
