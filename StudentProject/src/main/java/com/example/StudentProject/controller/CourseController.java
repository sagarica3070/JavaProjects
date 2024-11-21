package com.example.StudentProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentProject.entity.Course;
import com.example.StudentProject.entity.Student;
import com.example.StudentProject.service.CourseService;
import com.example.StudentProject.service.StudentService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	public CourseService courseService; 
	@PostMapping("/save")
	public Course saveCourse(@RequestBody Course course)
	{
		return courseService.saveCourse(course);
	}
	
	
	


}
