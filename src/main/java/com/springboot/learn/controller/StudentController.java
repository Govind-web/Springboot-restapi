package com.springboot.learn.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learn.dto.AddStudentRequestDto;
import com.springboot.learn.dto.StudentDto;
import com.springboot.learn.entity.Student;
import com.springboot.learn.repository.StudentRepository;
import com.springboot.learn.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	//private final StudentRepository studentRepository;
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService=studentService;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public ResponseEntity<List<StudentDto>> getStudent(){
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@PostMapping("/insert")
	public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
		studentService.deleteStudentById(id);
	   return	 ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
			@RequestBody AddStudentRequestDto aaAddStudentRequestDto){
		return ResponseEntity.ok(studentService.updateStudent(id,aaAddStudentRequestDto));
	}
	
	/*
	 * 
	 * 
	@GetMapping("/student/{id}")
	public StudentDto getStudentById(){
		return new StudentDto(4L,"Anuj","anuj@gmail.com");
	}*/
}
