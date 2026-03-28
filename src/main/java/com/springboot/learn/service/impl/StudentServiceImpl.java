package com.springboot.learn.service.impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.learn.dto.AddStudentRequestDto;
import com.springboot.learn.dto.StudentDto;
import com.springboot.learn.entity.Student;
import com.springboot.learn.repository.StudentRepository;
import com.springboot.learn.service.StudentService;

@Service
public  class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final ModelMapper modelMapper;
	
	
	public StudentServiceImpl(StudentRepository studentRepository,ModelMapper modelMapper) {
		
		this.studentRepository = studentRepository;
		this.modelMapper=modelMapper;
	}

	

	@Override
	public List<StudentDto> getAllStudent(){
		List<Student> student=studentRepository.findAll();	
		return student.stream()
				.map(studen->new StudentDto(studen.getStdId(),studen.getName(),studen.getEmail())
						).toList();
	}
	
	@Override
	public StudentDto getStudentById(Long id) {
		Student students= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found"));
		return modelMapper.map(students,StudentDto.class);
		
	}
	
	@Override
	public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
		Student newStudent=modelMapper.map(addStudentRequestDto, Student.class);
		Student student=studentRepository.save(newStudent);
		return modelMapper.map(student,StudentDto.class);
	}
	
	@Override
	public void deleteStudentById(Long id) {
		if(!studentRepository.existsById(id)) {
			throw new IllegalArgumentException("Student does not exist by id"+id);
		}
		studentRepository.deleteById(id);
	}
	
	@Override
	public StudentDto updateStudent(Long id,AddStudentRequestDto addStudentRequestDto) {
		Student students= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found"+id));
		 modelMapper.map(addStudentRequestDto, students);
		students= studentRepository.save(students);
		return modelMapper.map(students,StudentDto.class);
	}
	@Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
