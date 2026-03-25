package com.springboot.learn.service;

import java.util.List;

import com.springboot.learn.dto.StudentDto;

public interface StudentService {
	List<StudentDto> getAllStudent();
	
	StudentDto  getStudentById(Long id);

}
