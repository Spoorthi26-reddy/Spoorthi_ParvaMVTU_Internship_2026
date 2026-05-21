package com.library.controller;

import com.library.entity.BookIssue;
import com.library.service.BookIssueService;
import com.library.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class StudentDashboardController {

    private final BookService bookService;
    private final BookIssueService bookIssueService;

    public StudentDashboardController(BookService bookService,
                                      BookIssueService bookIssueService) {

        this.bookService = bookService;
        this.bookIssueService = bookIssueService;
    }

    @GetMapping("/student/dashboard")
    public String studentDashboard(Model model, Principal principal) {

        String email = principal.getName();

        List<BookIssue> studentIssues =
                bookIssueService.getIssuesByStudentEmail(email);

        long issuedBooks = studentIssues.stream()
                .filter(issue -> "ISSUED".equals(issue.getStatus()))
                .count();

        long returnedBooks = studentIssues.stream()
                .filter(issue -> "RETURNED".equals(issue.getStatus()))
                .count();

        double pendingFine = issuedBooks * 50;

        model.addAttribute("totalBooks",
                bookService.getAllBooks().size());

        model.addAttribute("issuedBooks", issuedBooks);

        model.addAttribute("returnedBooks", returnedBooks);

        model.addAttribute("pendingFine", pendingFine);

        return "student-dashboard";
    }

    @GetMapping("/student/books")
    public String studentBooks(Model model) {

        model.addAttribute("books",
                bookService.getAllBooks());

        return "student-books";
    }

    @GetMapping("/student/history")
    public String studentHistory(Model model, Principal principal) {

        String email = principal.getName();

        model.addAttribute("issues",
                bookIssueService.getIssuesByStudentEmail(email));

        return "student-history";
    }
}