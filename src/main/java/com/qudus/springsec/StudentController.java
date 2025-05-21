package com.qudus.springsec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudus.springsec.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "John Doe", 85),
        new Student(2, "Jane Smith", 90),
        new Student(3, "Sam Brown", 78)
    ));
    
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken)request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
