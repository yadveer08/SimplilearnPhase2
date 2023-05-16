package com.simplilearn.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="student_id")
    private int student_id;
    
    @Column(name="name")
    private String name;
    
    private String address;
    
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="class_id")
	private SchoolClass schoolClass;
    
    
    // other fields, getters and setters


	public String getAddress() {
		return address;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}