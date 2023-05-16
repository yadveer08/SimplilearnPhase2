package com.simplilearn.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="class_name")
    private String name;
    
    private List<Subject> subjects;
    
    // other fields, getters and setters
	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public Object getTeacherSubjectMap() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public void setName(String name) {
		this.name = name;
	}
}
