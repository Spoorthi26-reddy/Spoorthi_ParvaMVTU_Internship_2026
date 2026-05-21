package com.example.studentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentproject.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}