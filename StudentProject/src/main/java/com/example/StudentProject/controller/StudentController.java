package com.example.StudentProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentProject.entity.Student;
import com.example.StudentProject.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	public StudentService studentService; 
	
	
	@PostMapping("/saveStu")
	public Student saveStu(Student Student)
	{
		return studentService.saveStudent(Student);
	}
	
	
	@GetMapping("/get/{id}")
	public List<Student> findStudents(@PathVariable Long id)
	{
		return studentService.findByCourseId(id);
	}
	

}
