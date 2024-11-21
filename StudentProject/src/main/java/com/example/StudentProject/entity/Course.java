package com.example.StudentProject.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String title;

	    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "student_course",
	        joinColumns = @JoinColumn(name = "course_id"),
	        inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	    private List<Student> students;

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public List<Student> getStudents() {
	        return students;
	    }

	    public void setStudents(List<Student> students) {
	        this.students = students;
	    }
	}
	

