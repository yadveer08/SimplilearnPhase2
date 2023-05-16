package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_18042023")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private long student_id;

	@Column(name = "student_fname")
	private String fname;

	@Column(name = "student_lname")
	private String lname;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	List<PhoneNumber> phones;

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhones() {
		StringBuffer sb = new StringBuffer();
		if (phones != null) {
			for (PhoneNumber p : phones) {
				sb.append(p.getPhoneNumber() + ",");
			}
		}
		return sb.toString();
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}
}
