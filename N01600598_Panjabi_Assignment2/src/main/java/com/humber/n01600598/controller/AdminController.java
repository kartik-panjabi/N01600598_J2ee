package com.humber.n01600598.controller;

import com.humber.n01600598.entity.Student;
import com.humber.n01600598.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        logger.info("showLoginPage called Admin");
        return "admin-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        logger.info("login called Admin");
        boolean isAuthenticated = adminService.authenticateAdmin(email, password);
        if (isAuthenticated) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "admin-login";
        }
    }

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        logger.info("adminDashboard called Admin");
        List<Student> students = adminService.getAllStudents();
        model.addAttribute("students", students);
        return "admin-dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        logger.info("editStudent called Admin :"+id);
        Optional<Student> student = adminService.getStudentById(id);
        student.ifPresent(value -> model.addAttribute("student", value));
        return "admin-edit-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        logger.info("updateStudent called Admin");
        adminService.saveStudent(student);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        adminService.deleteStudent(id);
        return "redirect:/admin/dashboard";
    }
}
