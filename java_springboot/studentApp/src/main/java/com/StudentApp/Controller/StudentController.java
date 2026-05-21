//package com.StudentApp.Controller;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.studentapp.entity.Course;
//import com.example.studentapp.entity.Student;
//
//@Controller
//public class StudentController {
//
//    @Autowired
//    private com.StudentApp.Services.StudentService service;
//
//    @GetMapping("/")
//    public String viewHome(Model model) {
//        model.addAttribute("students", service.getAllStudents());
//        return "index";
//    }
//
//    @GetMapping("/new")
//    public String showForm(Model model) {
//        model.addAttribute("student", new Student());
//        return "form";
//    }
//
//    @PostMapping("/save")
//    public String saveStudent(@ModelAttribute Student student) {
//        service.saveStudent(student);
//        return "redirect:/";
//    }
//    
//    @SuppressWarnings("unchecked")
//	@PostMapping("/addCourse/{studentId}")
//    public String addCourse(@PathVariable Long studentId, @RequestParam String title) {
//
//        Student student = service.getStudentById(studentId);
//
//        Course course = new Course();
//        course.setTitle(title);
//        course.setStudent(student);
//
//        student.getCourses().addAll((Collection<? extends Student>) course);
//
//        service.saveStudent(student);
//
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        service.deleteStudent(id);
//        return "redirect:/";
//    }
//}

package com.StudentApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.StudentApp.Services.StudentService;
import com.StudentApp.entity.Student;
import com.StudentApp.entity.Course;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @PostMapping("/addCourse/{studentId}")
    public String addCourse(@PathVariable Long studentId, @RequestParam String title) {
        
        Student student = service.getStudentById(studentId);
        
        Course course = new Course();
        course.setTitle(title);
        course.setStudent(student);
        
        student.getCourses().add(course); // <-- Fixed line 47
        
        service.saveStudent(student);
        
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "form";
    }
}