package com.onlinejudge.domain.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 赵笑天
 *
 * @time 2015年10月4日
 * 
 */
@Entity
@Table(name="admin")
public class Admin {
	private int adminid;
	private String adminname;
	private String adminpassword;
	
	@Id
	@GeneratedValue
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname
				+ ", adminpassword=" + adminpassword + "]";
	}

}
