package com.company.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class SchoolClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int schoolClassId;
	private String name;
	
	@OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL)
	private List<Student> students;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Subject> subjects;
	
	@ManyToMany(mappedBy = "schoolClasses", cascade = CascadeType.ALL)
	private List<Teacher> teachers;
	
	// GETTERS AND SETTERS

	public int getSchoolClassId() {
		return schoolClassId;
	}

	public void setSchoolClassId(int schoolClassId) {
		this.schoolClassId = schoolClassId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
