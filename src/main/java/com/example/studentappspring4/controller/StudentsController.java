package com.example.studentappspring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentsController {

    @GetMapping("/students")
    public String getStudentsList() {
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

}


