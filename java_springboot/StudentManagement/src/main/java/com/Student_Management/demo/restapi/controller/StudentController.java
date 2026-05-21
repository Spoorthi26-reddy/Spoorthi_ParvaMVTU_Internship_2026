
//package com.Student_Management.demo.restapi.controller;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Student_Management.demo.entity.Student;
//import com.Student_Management.repository.StudentRepository;
//import com.Student_Management.repository.StudentRepositry;
//package com.Student_Management.controller;
//
//

//@RestController
//public class StudentController {
//	@Autowired
//	StudentRepository repo;
//	
//	@GetMapping("/students")
//	public List<Student> getAllStudents(){
//		List<Student> students = repo.findAll();
//		
//	return students;
//	
//	}
//	@GetMapping("/students/{id}")
//    public Student getStudent(@PathVariable int id) {
//        Student student = repo.findById(id).orElse(null);
//        return student;
//    }
//	
//	@PostMapping("/student/add")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public void createStudent(@RequestBody Student student) {
//		repo.save(student);
//	}
//	
//	@PutMapping("/student/update/{id}")
//	public Student updateStudents(@PathVariable int id) {
//		Student student = repo.findById(id).get();
//		student.setName("ganu");
//		student.setPercentage(92);
//		repo.save(student);
//		return student;
//	}
//	
//	@DeleteMapping("/student/delete/{id}")
//	public void removeStudent(@PathVariable int id) {
//		Student student = repo.findById(id).get();
//		repo.delete(student);
//	}
//	}




package com.Student_Management.demo.restapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import com.Student_Management.model.Student;
import com.Student_Management.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // GET ALL
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // GET BY ID
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // CREATE
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        repo.save(student);
    }

    // UPDATE
    @PutMapping("/student/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("ganu");
		student.setPercentage(92);
		repo.save(student);
		return student;
	}

    // DELETE
    @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id) {
        Student student = repo.findById(id).orElse(null);

        if (student != null) {
            repo.delete(student);
        }
    }
}
