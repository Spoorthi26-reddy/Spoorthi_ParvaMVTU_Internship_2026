package com.thymeleafcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleafcrud.model.Student;
import com.thymeleafcrud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	//create
	 public Student save(Student student) {
	        return studentRepository.save(student);
	    }
	    
	    public List<Student> findAll() {
	        return studentRepository.findAll();
	    }
	    
	    public Student findById(Long id) {
	        return studentRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Student not found: " + id));
	    }
	    
	    public Student update(Long id, Student updatedStudent) {
	        Student existing = findById(id);   // throws if not found
	        existing.setName(updatedStudent.getName());
	        existing.setEmail(updatedStudent.getEmail());
	        existing.setAge(updatedStudent.getAge());
	        existing.setCourse(updatedStudent.getCourse());
	        return studentRepository.save(existing);
	    }
	    
	    public StudentRepository getStudentRepository() {
			return studentRepository;
		}

		public void setStudentRepository(StudentRepository studentRepository) {
			this.studentRepository = studentRepository;
		}

		public void deleteById(Long id) {
	        if (!studentRepository.existsById(id)) {
	            throw new RuntimeException("Student not found: " + id);
	        }
	        studentRepository.deleteById(id);
	    }
	    public List<Student> search(String name) {
	    	 return studentRepository.findByNameContainingIgnoreCase(name);
	    }
	}



