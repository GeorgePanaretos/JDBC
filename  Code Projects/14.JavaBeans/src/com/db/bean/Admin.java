package com.db.bean;

import java.io.Serializable;
// This class represent a java bean
public class Admin implements Serializable{

	/**
	 * Serial Version generated
	 */ 
	private static final long serialVersionUID = 653544321221442l;
	private int adminId;
	private String userName;
	private String password;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
