package com.example.frontend.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping({"/", "/public/home"})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        // Add user info to model
        return "dashboard";
    }

    @GetMapping("/problems")
    public String problems(Model model) {
        // Get public problems from problem-service
        return "problems";
    }

//    @PreAuthorize("hasRole('participant')")
    @GetMapping("/submit/{problemId}")
    public String submissionPage(@PathVariable Long problemId, Model model) {
        model.addAttribute("problemId", problemId);
        return "submit";
    }

//    @PreAuthorize("hasRole('admin')")
    @GetMapping("/admin/users")
    public String adminUsers(Model model) {
        return "admin-users";
    }
}
