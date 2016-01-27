package com.onlinejudge.action;

import java.io.IOException;

import com.onlinejudge.constant.Status;
import com.onlinejudge.tool.ConfigsOperator;

/**
 * @author ��Ц��
 *
 * @time 2015��10��6��
 * 
 */
public class RoundAction {
	private int round;

	public int getRound() {
		return round;
	}

	public void setRound(String roundString) {
		try{
			this.round = Integer.parseInt(roundString);
			if (round < 1){
				this.round = -1;
			}
		}catch(Exception e){
			this.round = -1;
		}
	}
	
	public String setRound() throws IOException{
		ConfigsOperator co = new ConfigsOperator();
		if (round != -1){
			co.saveProperties("currentRound", round+"");
		}
		return Status.SUCCESS;
	}
}
