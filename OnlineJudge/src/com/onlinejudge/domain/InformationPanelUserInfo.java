package com.onlinejudge.domain;

/**
 * @author ��Ц��
 *
 * @time 2015��9��22��
 * 
 */
public class InformationPanelUserInfo {
	private int stuid;
	private String username;
	private String realname;
	private String qq;
	private String email;
	private String phonenum;
	private String faviconuri;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getFaviconuri() {
		return faviconuri;
	}
	public void setFaviconuri(String faviconuri) {
		this.faviconuri = faviconuri;
	}
	@Override
	public String toString() {
		return "InformationPanelUserInfo [stuid=" + stuid + ", username="
				+ username + ", realname=" + realname + ", qq=" + qq
				+ ", email=" + email + ", phonenum=" + phonenum
				+ ", faviconuri=" + faviconuri + "]";
	}
}
