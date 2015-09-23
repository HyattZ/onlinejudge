package com.onlinejudge.dto;

import org.springframework.stereotype.Component;

/**
 * @author ��Ц��
 *
 * @time 2015��9��17��
 * 
 */
@Component("resultFormBean")
public class ResultFormBean {
	private int problemid;
	private String flag;
	
	public ResultFormBean(){
		
	}
	
	public int getProblemid() {
		return problemid;
	}
	public void setProblemid(int problemid) {
		
		this.problemid = problemid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * 
	 * ���ܣ���֤flag�ĺϷ���,��֤������ĸ�����ֹ��ɵĳ��Ȳ�����100���ַ���
	 * 
	 * */
	public boolean validateFlag(){
		String regex = "[A-Za-z0-9]+";
		return (this.flag.matches(regex) & this.flag.length() < 100 );
	}
	
}
