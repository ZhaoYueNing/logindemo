package cn.zhaoyuening.domain;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private String email;
	//性别：0 为女性 1为男性
	private int gender;
	//出生日期
	private Date birth;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	} 	
	
	
}	
