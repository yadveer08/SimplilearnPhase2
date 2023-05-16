package com.simplilearn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_d")
    private Long teacher_id;
    
    private String fname;
    
    private String lname;
    
    private String phone;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Subject> subjects;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="teacher_classes_link",
    			joinColumns = {@JoinColumn(name="teacher_id")},
    			inverseJoinColumns = {@JoinColumn(name="class_id")}
    		)
    private List<SchoolClass> classes;
    
    public Teacher() {}

    
    public Teacher(String fname, String lname, String phone) {
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
	}
    
    // GETTERS AND SETTERS
    
	
	public String getFname() {
		return fname;
	}
	public Long getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public List<SchoolClass> getClasses() {
		return classes;
	}


	public void setClasses(List<SchoolClass> classes) {
		this.classes = classes;
	}

	

}