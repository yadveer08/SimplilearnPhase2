package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_detail")
public class AdminDetail {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="password")
	private String password;

	public String getAdminName() {
		return adminName;
	}

	@Override
	public String toString() {
		return "AdminDetail [adminName=" + adminName + ", password=" + password + "]";
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
