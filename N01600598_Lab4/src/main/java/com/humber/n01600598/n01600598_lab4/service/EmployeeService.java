package com.humber.n01600598.n01600598_lab4.service;

import com.humber.n01600598.n01600598_lab4.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final Map<Long, Employee> employees = new HashMap<>();
    private Long nextId = 1L; // To generate unique IDs

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employees.values().stream().collect(Collectors.toList());
    }


    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        return employees.get(id);
    }

    // Save or update employee
    public Employee saveEmployee(Employee employee) {

        if (employee.getId() == null) {
            employee.setId(nextId++); // Assign a ne    w ID
        }
        employees.put(employee.getId(), employee);
        return employee;
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employees.remove(id);
    }
}