package com.StudentApp.Services;

import org.springframework.stereotype.Service;
import com.StudentApp.repository.StudentRepository;
import com.StudentApp.entity.Student;
import java.util.List;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
}