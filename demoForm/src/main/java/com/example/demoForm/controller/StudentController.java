package com.example.demoForm.controller;

import com.example.demoForm.entity.Student;
import com.example.demoForm.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // Open HTML form
    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    // Save form data
    @PostMapping("/save-student")
    public String saveStudent(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            Model model) {


        Student student = new Student();

        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);

        studentRepository.save(student);

        model.addAttribute(
                "message",
                "Student saved successfully!"
        );

        return "index";
    }

}