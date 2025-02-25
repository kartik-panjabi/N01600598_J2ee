    package com.humber.n01600598.controller;

    import com.humber.n01600598.entity.Student;
    import com.humber.n01600598.service.StudentService;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    @Controller
    @RequestMapping("/students")
    public class StudentController {

        private final StudentService studentService;
        private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @GetMapping("/register")
        public String showRegistrationPage(Model model) {
            logger.info("showRegistrationPage");
            model.addAttribute("student", new Student());
            return "student-register";
        }

        @PostMapping("/register")
        public String registerStudent(@ModelAttribute Student student, Model model) {
            logger.info(student.toString());
            studentService.registerStudent(student);
            model.addAttribute("success", "Registration successful! Please login.");
            return "student-login";
        }

        @GetMapping("/login")
        public String showLoginPage() {
            logger.info("showLoginPage");
            return "student-login";
        }



        @PostMapping("/login")
        public String login(@RequestParam String email, @RequestParam String password, Model model) {
            // Log the login attempt
            logger.info("Login attempt for email: {}", email);

            return studentService.authenticate(email, password)
                    .map(student -> {
                        // Log successful login
                        logger.info("Login successful for email: {}", email);
                        model.addAttribute("student", student);
                        return "student-dashboard"; // Redirect to student dashboard on success
                    })
                    .orElseGet(() -> {
                        // Log failed login
                        logger.warn("Login failed for email: {}", email);
                        model.addAttribute("error", "Invalid Credentials");
                        return "student-login"; // Show login page with error message
                    });
        }


        @GetMapping("/dashboard")
        public String showDashboard(Model model) {
            // You can add any necessary model attributes here
            logger.info("showDashboard");
            return "student-dashboard";  // This is the name of your HTML template for the dashboard page
        }


    }
