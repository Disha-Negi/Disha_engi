package com.user.model;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private String passwd;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", passwd=" + passwd + "]";
	}
	
	
	
	

}

