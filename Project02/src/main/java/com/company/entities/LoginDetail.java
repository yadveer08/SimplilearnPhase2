package com.company.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetail {
	
	@Id
	private String loginId;
	
	private String password;
	

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
