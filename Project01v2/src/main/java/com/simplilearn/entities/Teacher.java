package com.simplilearn.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    
    @Column(name="phone")
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "teacher_class",
            joinColumns = { @JoinColumn(name = "teacher_id") },
            inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    private Set<Classs> classes = new HashSet<>();

    public Teacher() {}

    public Teacher(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Classs> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classs> classes) {
        this.classes = classes;
    }

    public void addClass(Classs clazz) {
        this.classes.add(clazz);
        clazz.getTeachers().add(this);
    }

    public void removeClass(Classs clazz) {
        this.classes.remove(clazz);
        clazz.getTeachers().remove(this);
    }
}

