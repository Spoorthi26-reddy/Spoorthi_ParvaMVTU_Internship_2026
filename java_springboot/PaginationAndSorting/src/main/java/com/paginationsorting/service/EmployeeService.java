package com.paginationsorting.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.paginationsorting.model.Employee;
import com.paginationsorting.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository repo;
	
	public EmployeeService(EmployeeRepository repo) {
		this.repo = repo;
		}
		/**
		* Returns one page of employees, sorted by the given field and direction.
		*
		* @param pageNo zero-based page index (0 = first page)
		* @param pageSize number of rows per page (e.g. 5, 10, 20)
		* @param sortField DB column to sort by (id | name | salary | department)
		* @param sortDir "asc" or "desc"
		* @return Spring Page object wrapping the result list + metadata
		*/
		public Page<Employee> getEmployees(int pageNo, int pageSize,
		String sortField, String sortDir) {
		// Build the Sort object (direction + property)
		Sort sort = sortDir.equalsIgnoreCase("asc")
		? Sort.by(sortField).ascending()
		: Sort.by(sortField).descending();
		// PageRequest implements Pageable
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		// Single call — Spring generates the LIMIT/OFFSET + ORDER BY SQL
		return repo.findAll(pageable);
		}
}
