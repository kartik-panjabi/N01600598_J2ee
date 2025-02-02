package com.n01600598.week3.service;

import com.n01600598.week3.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees); // Return a copy to prevent external modification
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public boolean updateEmployee(Employee employee) {
        Employee existingEmployee = getEmployeeById(employee.getId());
        if (existingEmployee != null) {
            existingEmployee.setFirst_name(employee.getFirst_name());
            existingEmployee.setLast_name(employee.getLast_name());
            existingEmployee.setEmail(employee.getEmail());
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }
}
