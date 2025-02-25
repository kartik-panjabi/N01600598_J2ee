package com.humber.n01600598.service;

import com.humber.n01600598.entity.Student;
import com.humber.n01600598.repository.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor
    public AdminService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Authenticate admin login
    public boolean authenticateAdmin(String email, String rawPassword) {
        // You need to store admin credentials in the database (for now, hardcoded example)
        String adminEmail = "admin@example.com";
        String hashedAdminPassword = passwordEncoder.encode("admin123"); // Save hashed password in DB

        return email.equals(adminEmail) && passwordEncoder.matches(rawPassword, hashedAdminPassword);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Create or update a student
    public Student saveStudent(Student student) {
        if (student.getPassword() != null && !student.getPassword().isEmpty()) {
            student.setPassword(passwordEncoder.encode(student.getPassword())); // Encrypt password
        }
        return studentRepository.save(student);
    }

    // Soft delete student (set deleted = true)
    public void deleteStudent(Long id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        studentOpt.ifPresent(student -> {
            student.setDeleted(true);
            studentRepository.save(student);
        });
    }
}
