//package com.example.studentapp.entity;
//import jakarta.persistence.*;
//
//	
//	
//
//	@Entity
//	public class Course {
//
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    private String title;
//
//	    @ManyToOne
//	    @JoinColumn(name = "student_id")
//	    private Student student;
//
//		public void setTitle(String title2) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		public void setStudent(Student student2) {
//			// TODO Auto-generated method stub
//			
//		}
//
//	    // getters & setters
//	}
//

//package com.StudentApp.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Course {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
//
//    // ✅ GETTERS & SETTERS
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {   // 🔥 THIS FIXES ERROR
//        this.title = title;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {  // 🔥 THIS FIXES ERROR
//        this.student = student;
//    }
//}

package com.StudentApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;  // <-- Needed for setTitle()
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;  // <-- Needed for setStudent()
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}