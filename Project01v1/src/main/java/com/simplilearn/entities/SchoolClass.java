package com.simplilearn.entities;

import java.util.ArrayList;
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.util.HibernateUtil;


@Entity
@Table(name = "SchoolClasses")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="class_id")
    private Long class_id;
    
    public Long getClass_id() {
		return class_id;
	}
	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}
	private String name;
    
	@OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> students;
    
    @ManyToMany(mappedBy = "classes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Subject> subjects;
    
    @ManyToMany(mappedBy = "classes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teacher> teachers;
    
    // other fields, getters and setters

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Student> getStudents() {
        return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	
}
