package com.paginationsorting.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paginationsorting.model.Employee;
import com.paginationsorting.service.EmployeeService;

@Controller
public class EmployeeController {
	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	/**
	 * Thymeleaf view Handles: GET /employees?page=0&size=10&sort=name&dir=asc
	 *
	 * Default values keep the URL clean on first visit.
	 */
	@GetMapping("/employees")
	public String listEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "asc") String dir,
			Model model) {
		Page<Employee> empPage = service.getEmployees(page, size, sort, dir);
		model.addAttribute("employees",empPage.getContent());
		model.addAttribute("currentPage", empPage.getNumber());
		model.addAttribute("totalPages", empPage.getTotalPages());
		model.addAttribute("totalItems", empPage.getTotalElements());
		model.addAttribute("pageSize", size);
		model.addAttribute("sortField", sort);
		model.addAttribute("sortDir", dir);
		// Toggle direction for next header click
		model.addAttribute("reverseSortDir", dir.equals("asc") ? "desc" : "asc");
		return "employee_list"; // resolves to templates/employees.html
	}

}
