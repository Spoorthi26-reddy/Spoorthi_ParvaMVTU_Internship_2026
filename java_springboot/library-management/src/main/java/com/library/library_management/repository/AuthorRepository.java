//package com.library.library_management.repository;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.library.entity.Author;
//
//public interface AuthorRepository extends JpaRepository<Author, Long> {
//}
package com.library.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.library_management.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}