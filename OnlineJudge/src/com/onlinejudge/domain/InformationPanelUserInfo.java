package com.onlinejudge.domain;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
public class InformationPanelUserInfo {
	private int stuid;
	private String username;
	private String nickname;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
				+ username + ", nickname=" + nickname + ", qq=" + qq
				+ ", email=" + email + ", phonenum=" + phonenum
				+ ", faviconuri=" + faviconuri + "]";
	}
}
