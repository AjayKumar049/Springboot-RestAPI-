package com.example.StudentManagementSystem.dto;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;

public class StudentDto {
	
	@NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

	public StudentDto(String name, String address, String email) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
    

}
