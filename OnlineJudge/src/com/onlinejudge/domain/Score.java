package com.onlinejudge.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author 赵笑天
 *
 * @time 2015年9月15日
 * 
 */
@Entity
@Table(name="score")
public class Score {
	private int stuid;
	private double score;
	
	public Score(){
		
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	@Id
	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	@Override
	public String toString() {
		return "Score [stuid=" + stuid + ", score=" + score + "]";
	}
}
