package com.springboot.learn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learn.dto.StudentDto;
import com.springboot.learn.entity.Student;
import com.springboot.learn.repository.StudentRepository;
import com.springboot.learn.service.StudentService;

@RestController
public class StudentController {

	//private final StudentRepository studentRepository;
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService=studentService;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/student")
	public List<StudentDto> getStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/student/{id}/{name}")
	public String getStudentById(@PathVariable Long id,@PathVariable String name){
		return "path varible"+id+" is "+name; 
	}
	/*
	 * 
	 * 
	@GetMapping("/student/{id}")
	public StudentDto getStudentById(){
		return new StudentDto(4L,"Anuj","anuj@gmail.com");
	}*/
}
