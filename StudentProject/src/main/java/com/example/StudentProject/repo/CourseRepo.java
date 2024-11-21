package com.example.StudentProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentProject.entity.Course;
import com.example.StudentProject.entity.Student;

public interface CourseRepo extends   JpaRepository<Course, Long>  {

}
