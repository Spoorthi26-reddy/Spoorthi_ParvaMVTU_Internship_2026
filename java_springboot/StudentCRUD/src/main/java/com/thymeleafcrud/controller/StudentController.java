package com.thymeleafcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thymeleafcrud.model.Student;
import com.thymeleafcrud.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private com.thymeleafcrud.service.StudentService studentService;
	
	 @GetMapping
	   public String listAll(Model model) {
	        model.addAttribute("students", studentService.findAll());
	        return "students/list";  // → templates/students/list.html
	 }
	 
	 @GetMapping("/{id}")
    public String viewOne(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "students/view";
    }
	 
	 @GetMapping("/new")
	    public String showCreateForm(Model model) { //model to send data from backend to frontend
	        model.addAttribute("student", new com.thymeleafcrud.model.Student());
	        model.addAttribute("formTitle", "Add New Student");
	        return "students/form";
	 }
	 
	@PostMapping
    public String create(@Valid @ModelAttribute Student student, // modelattribaute get data from frontend to backend
                         BindingResult result, Model model,
                         RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            model.addAttribute("formTitle", "Add New Student");
            return "students/form";
        }
        studentService.save(student);
        redirectAttrs.addFlashAttribute("success", "Student created!");
        return "redirect:/students";
    }
	
	 @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("formTitle", "Edit Student");
        return "students/form";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute com.thymeleafcrud.model.Student student,
                         BindingResult result, Model model,
                         RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            model.addAttribute("formTitle", "Edit Student");
            return "students/form";
        }
        studentService.update(id, student);
        redirectAttrs.addFlashAttribute("success", "Student updated!");
        return "redirect:/students";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id,
                          RedirectAttributes redirectAttrs) {
        studentService.deleteById(id);
        redirectAttrs.addFlashAttribute("success", "Student deleted!");
        return "redirect:/students";
    }
}
