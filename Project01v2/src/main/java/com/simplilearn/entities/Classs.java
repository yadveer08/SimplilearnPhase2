package com.simplilearn.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class")
public class Classs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "clazz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "clazz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "teacher_class",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")}
    )
    private Set<Teacher> teachers = new HashSet<>();

    public Classs() {}

    public Classs(String name) {
        this.name = name;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setClazz(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setClazz(null);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setClazz(this);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
        subject.setClazz(null);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.getClasses().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.getClasses().remove(this);
    }
}
   


