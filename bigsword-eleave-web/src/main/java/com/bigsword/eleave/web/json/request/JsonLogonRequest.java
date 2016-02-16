package com.bigsword.eleave.web.json.request;

import com.bigsword.eleave.web.json.base.RequestBase;

public class JsonLogonRequest extends RequestBase{
	private String username;
	private String password;
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
	
	
}
