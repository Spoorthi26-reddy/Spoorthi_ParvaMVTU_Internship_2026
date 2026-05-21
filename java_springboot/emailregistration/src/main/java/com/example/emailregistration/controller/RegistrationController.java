package com.example.emailregistration.controller;

import com.example.emailregistration.model.User;
import com.example.emailregistration.repository.UserRepository;
import com.example.emailregistration.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Controller
public class RegistrationController {

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private UserDetailsRepositoryReactiveAuthenticationManager userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String submitRegistration(@ModelAttribute("user") User user, Model model) {
        
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already registered!");
            model.addAttribute("user", user);
            return "register";
        }
        
        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Username already taken!");
            model.addAttribute("user", user);
            return "register";
        }

        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(false);
            user.setVerificationToken(UUID.randomUUID().toString());
            
            User savedUser = userRepository.save(user);
            emailService.sendEmail(savedUser);
            
            model.addAttribute("user", savedUser); 
            model.addAttribute("registeredDate", LocalDate.now().toString());
            return "success";
            
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            model.addAttribute("user", user);
            return "register";
        }
    }
    
    @GetMapping("/verify")
    public String verifyUser(@RequestParam String token, Model model) {
        Optional<User> userOptional = userRepository.findByVerificationToken(token);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEnabled(true);
            user.setVerificationToken(null);
            userRepository.save(user);
            model.addAttribute("message", "Email verified! You can now login.");
        } else {
            model.addAttribute("message", "Invalid or expired token");
        }
        return "verify-result";
    }
}