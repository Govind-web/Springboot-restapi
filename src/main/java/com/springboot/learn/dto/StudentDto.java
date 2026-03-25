package com.springboot.learn.dto;

public class StudentDto {
	private Long stdId;
	private String name;
	private String email;
	public StudentDto(Long stdId, String name, String email) {
		super();
		this.stdId = stdId;
		this.name = name;
		this.email = email;
	}
	public StudentDto() {
		
		// TODO Auto-generated constructor stub
	}
	public Long getStdId() {
		return stdId;
	}
	public void setStdId(Long stdId) {
		this.stdId = stdId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
