package com.antonio.chainOfResponsibility;

public  class User{
	private int userID;
	private String userName;
	private int classid;

	public User(int userID, String userName, int classid) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.classid = classid;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}
	
}
