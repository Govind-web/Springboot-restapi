package com.springboot.learn.service;

import java.util.List;
import java.util.Map;

import com.springboot.learn.dto.AddStudentRequestDto;
import com.springboot.learn.dto.StudentDto;

public interface StudentService {
	List<StudentDto> getAllStudent();
	
	StudentDto  getStudentById(Long id);
	
	StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
	
	

	void deleteStudentById(Long id);
	
	StudentDto updateStudent(Long id,AddStudentRequestDto addStudentRequestDto);
	
	StudentDto updatePartialStudent(Long id,Map<String, Object> update);
}
