package com.example.StudentManagementSystem.repository;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.model.Student;



@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Student> studentRowMapper = (rs, rowNum) -> {
        Student s = new Student();
        s.setId(rs.getLong("id"));
        s.setName(rs.getString("name"));
        s.setAddress(rs.getString("address"));
        s.setEmail(rs.getString("email"));
        return s;
    };

    public void save(Student student) {
        String sql = "INSERT INTO students (name, address, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getAddress(), student.getEmail());
    }

    public Student findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM students WHERE id = ?", studentRowMapper, id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    public boolean existsByEmail(String email) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM students WHERE email = ?", Integer.class, email);
        return count != null && count > 0;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM students WHERE id = ?", id);
    }
}

