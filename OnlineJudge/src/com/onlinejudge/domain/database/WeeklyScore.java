package com.onlinejudge.domain.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author ��Ц��
 *
 * @time 2015��9��25��
 * 
 */
@Entity
@Table(name="weeklyScore")
public class WeeklyScore {
	private int stuid;
	private double score;
	
	public WeeklyScore(){
		
	}
	
	@Id
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "WeeklyScore [stuid=" + stuid + ", score=" + score + "]";
	}
	
	
}
