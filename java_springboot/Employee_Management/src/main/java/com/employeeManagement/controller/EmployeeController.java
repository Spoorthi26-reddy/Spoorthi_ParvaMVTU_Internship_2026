package com.employeeManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.employeeManagement.model.Employee;
import com.employeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
//        model.addAttribute("listEmployees", service.getAllEmployees());
    	model.addAttribute("listEmployees", service.getAllEmployees()); // add 's'
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Employee emp = service.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "update-employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }
}