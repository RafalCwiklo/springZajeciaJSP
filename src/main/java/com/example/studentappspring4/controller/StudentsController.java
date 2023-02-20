package com.example.studentappspring4.controller;

import com.example.studentappspring4.model.StudentModel;
import com.example.studentappspring4.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable("id") Long id, Model model) {
        StudentModel student = service.getStudentById(id);
        model.addAttribute("studentModel", student);
        return "/persons/editPerson";
    }
    @PostMapping("/addStudent/{id}")
    public RedirectView postEditStudent(StudentModel editStudent) {
        service.saveEditStudent(editStudent);
        return new RedirectView("/addStudent/{id}");
    }
    @PostMapping("/editStudent/{id}")
    public RedirectView deleteStudent(@PathVariable("id") Long id) {
        service.deleteStudent(id);
        return new RedirectView("/student");
    }

}


