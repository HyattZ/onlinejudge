package com.onlinejudge.service;

/**
 * @author ��Ц��
 *
 * @time 2015��9��25��
 * 
 */
public interface SubmitTimesService {
	//���û�д�����¼����ô����һ���µļ�¼����ʼ����ֵ�������1
	public abstract void subTimes(int stuid, int problemid);
	
	public abstract boolean checkSubmittimes(int stuid,int problemid);

}
