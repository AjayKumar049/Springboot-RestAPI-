package com.example.StudentManagementSystem.controller;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.StudentManagementSystem.dto.StudentDto;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@Valid @RequestBody StudentDto dto) {
        return studentService.createStudent(dto);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Deleted successfully";
    }
}

