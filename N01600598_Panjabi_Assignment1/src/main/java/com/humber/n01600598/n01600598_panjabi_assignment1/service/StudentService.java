package com.humber.n01600598.n01600598_panjabi_assignment1.service;


import com.humber.n01600598.n01600598_panjabi_assignment1.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
