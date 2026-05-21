package com.StudentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.StudentApp.entity.Course; 

public interface CourseRepository extends JpaRepository<Course, Long> {
}