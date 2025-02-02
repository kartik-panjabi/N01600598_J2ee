package com.n01600598.week3.controller;

import com.n01600598.week3.model.Employee;
import com.n01600598.week3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees") // Set base path for all mappings
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmp";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees/";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return "error"; // Redirect to an error page if not found
        }
        model.addAttribute("employee", employee);
        return "editEmp";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute Employee employee) {
        employee.setId(id);
        if (!employeeService.updateEmployee(employee)) {
            return "error"; // Redirect to an error page if update fails
        }
        return "redirect:/employees/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        if (!employeeService.deleteEmployee(id)) {
            return "error"; // Redirect to an error page if deletion fails
        }
        return "redirect:/employees/";
    }
}
