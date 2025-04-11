package com.example.StudentManagementSystem.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.dto.StudentDto;
import com.example.StudentManagementSystem.exception.ResourceAlreadyExistsException;
import com.example.StudentManagementSystem.exception.ResourceNotFoundException;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(StudentDto dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists");
        }

        Student student = new Student();
        student.setName(dto.getName());
        student.setAddress(dto.getAddress());
        student.setEmail(dto.getEmail());

        repository.save(student);
        return student;
    }

    public Student getStudent(Long id) {
        Student student = repository.findById(id);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        return student;
    }

    public void deleteStudent(Long id) {
        if (repository.findById(id) == null) {
            throw new ResourceNotFoundException("Student not found");
        }
        repository.deleteById(id);
    }
}

