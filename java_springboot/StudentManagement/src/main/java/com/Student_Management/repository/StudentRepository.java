//package com.Student_Management.repositry;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.Student_Management.demo.entity.Student;
//
//public interface StudentRepositry extends JpaRepository<Student, Integer> {
//
//	List<Student> findAll();
//	
//}

package com.Student_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Student_Management.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
