package com.example.studentproject.controller;

import com.example.studentproject.entity.Student;
import com.example.studentproject.entity.Subject;
import com.example.studentproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Show all students
    @GetMapping("/students")
    public String viewStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    // Show form
    @GetMapping("/addStudent")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // Save student
//    @PostMapping("/saveStudent")
//    public String saveStudent(@ModelAttribute Student student) {
//        studentService.saveStudent(student);
//        return "redirect:/students";
    @PostMapping("/saveStudent")
    public String saveStudent(
            @ModelAttribute Student student,
            @RequestParam(value = "subjectIds", required = false) String subjectIds) {

        try {

            // Handle subjects safely
            if (subjectIds != null && !subjectIds.isEmpty()) {
                List<Subject> subjects = Arrays.stream(subjectIds.split(","))
                        .map(id -> {
                            Subject s = new Subject();
                            s.setId(Long.parseLong(id.trim()));
                            return s;
                        })
                        .collect(Collectors.toList());

                student.setSubjects(subjects);
            }

            studentService.saveStudent(student);

        } catch (Exception e) {
            e.printStackTrace(); // VERY IMPORTANT (see error in console)
        }

        return "redirect:/students";
    }
    }
