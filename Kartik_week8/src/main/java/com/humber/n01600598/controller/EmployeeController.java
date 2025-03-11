package com.humber.n01600598.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String showEmployeeListPage() {
        return "employees"; // Loads employees.html
    }

    @GetMapping("/employees/add")
    public String showAddEmployeePage() {
        return "add-employee"; // Loads add-employees.html
    }

    @GetMapping("/employees/edit")
    public String showEditEmployeePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("employeeId", id);
        return "edit-employee"; // Loads edit-employees.html
    }
}
