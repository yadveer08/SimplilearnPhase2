package com.simplilearn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "Subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subject_id;
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SchoolClass> classes;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    
    public Subject() {}
    public Subject(String name) {
    	this.name = name;
    }
    
    // other fields, getters and setters

    
	public Long getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}
	
    public List<SchoolClass> getClasses() {
		return classes;
	}
	public void setClasses(List<SchoolClass> classes) {
		this.classes = classes;
	}
	public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
