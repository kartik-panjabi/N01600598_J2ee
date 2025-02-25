package com.humber.n01600598.service;

import com.humber.n01600598.entity.Student;
import com.humber.n01600598.repository.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Register a new student (Hash password before saving)
    public Student registerStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword())); // Encrypt password
        return studentRepository.save(student);
    }

    // Authenticate student login
    public Optional<Student> authenticate(String email, String rawPassword) {
        System.out.println("Authentication attempt for email: " + email); // Log print
        return studentRepository.findByEmail(email)
                .filter(student -> passwordEncoder.matches(rawPassword, student.getPassword()));
    }


    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Get all students

    // Update student details
    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudentOpt = studentRepository.findById(id);
        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setAddress(updatedStudent.getAddress());

            if (updatedStudent.getPassword() != null && !updatedStudent.getPassword().isEmpty()) {
                existingStudent.setPassword(passwordEncoder.encode(updatedStudent.getPassword())); // Hash new password
            }

            return studentRepository.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found");
        }
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
