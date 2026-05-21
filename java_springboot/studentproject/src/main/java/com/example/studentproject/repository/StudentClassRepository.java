package com.example.studentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentproject.entity.StudentClass;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
}