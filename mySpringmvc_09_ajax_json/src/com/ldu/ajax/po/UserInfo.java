package com.ldu.ajax.po;

public class UserInfo {
	private int id;
	private String userName;
	private String age;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int id, String userName, String age) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	/*@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", age=" + age
				+ "]";
	}*/
}
