package com.humber.n01600598.n01600598_panjabi_assignment1.service;

import com.humber.n01600598.n01600598_panjabi_assignment1.entity.Student;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    public StudentServiceImpl() {

        studentMap.put(1, new Student(1, "Aarav", 22, "Male", "aarav@example.com", "Mumbai", "2002-05-12"));
        studentMap.put(2, new Student(2, "Priya", 23, "Female", "priya@example.com", "Delhi", "2001-08-21"));
        studentMap.put(3, new Student(3, "Raj", 21, "Male", "raj@example.com", "Bangalore", "2003-02-14"));

    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }
}
