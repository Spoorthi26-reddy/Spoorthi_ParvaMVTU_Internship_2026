package com.example.studentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentproject.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}