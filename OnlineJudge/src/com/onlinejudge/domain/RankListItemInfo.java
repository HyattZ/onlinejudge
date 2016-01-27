package com.onlinejudge.domain;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
public class RankListItemInfo {
	
	private String username;
	private double score;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "RankListItemInfo [username=" + username + ", score=" + score;
	}
}
