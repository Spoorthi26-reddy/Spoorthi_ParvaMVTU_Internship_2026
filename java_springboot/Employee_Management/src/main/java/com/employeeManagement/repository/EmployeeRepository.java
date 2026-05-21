package com.employeeManagement.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findAll();

	Employee save(Employee employee);
}