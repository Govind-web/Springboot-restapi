package com.springboot.learn.dto;

public class AddStudentRequestDto {
	
		private String name;
		private String email;
		public AddStudentRequestDto( String name, String email) {
			super();
			
			this.name = name;
			this.email = email;
		}
		public AddStudentRequestDto() {
			
			// TODO Auto-generated constructor stub
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
