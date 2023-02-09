package com.example.studentappspring4.controller;

import com.example.studentappspring4.model.StudentModel;
import com.example.studentappspring4.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StudentsController {

    private final StudentService service;

    @GetMapping("/students")
    public String getStudentsList(Model model) {
        List<StudentModel> studentModelList = service.getAllStudents();
        model.addAttribute("studentModel", studentModelList);
        return "/persons/personList";
    }

    @GetMapping("/editStudent")
    public String getEditStudent() {
        return "/persons/editPerson";
    }
    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "/persons/addNewPerson";
    }

    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel student) {
       service.addStudent(student);
        return new RedirectView("/students");
    }


}


