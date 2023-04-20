package com.example.action;

import com.example.service.IdentityService;

public class PersonAction {
	private String userName;
	private String pass;
	private IdentityService identityService;
	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String execute(){
		int result=identityService.addUser(userName,pass);
		if (result>0)
			return "success";
		else
			return "error";
	}

}
