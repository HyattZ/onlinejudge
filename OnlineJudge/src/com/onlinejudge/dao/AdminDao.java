package com.onlinejudge.dao;

import com.onlinejudge.domain.database.Admin;

/**
 * @author ��Ц��
 *
 * @time 2015��10��4��
 * 
 */
public interface AdminDao {

	public abstract Admin getAdminByAdminname(String adminname);
	
}
