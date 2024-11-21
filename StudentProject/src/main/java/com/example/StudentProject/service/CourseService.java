package com.example.StudentProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentProject.entity.Course;
import com.example.StudentProject.repo.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	public CourseRepo courseRepo;
	
	public Course saveCourse(Course course)
	{
		return courseRepo.save(course);
	}
	
	public Optional<Course> getByStudentId(Long studentId)
	{
		return courseRepo.findById(studentId);
	}

}
