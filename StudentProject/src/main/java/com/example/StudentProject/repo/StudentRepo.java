package com.example.StudentProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentProject.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	   List<Student> findByCoursesId(Long courseId);
	
}
