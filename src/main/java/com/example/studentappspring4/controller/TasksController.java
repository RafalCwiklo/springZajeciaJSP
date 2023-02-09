package com.example.studentappspring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TasksController {


    @GetMapping("/tasks")
    public String getAllTasks() {
        return "/tasks/tasks";
    }

    @GetMapping("/addTask")
    public String getAddTask() {
        return "/tasks/addTask";
    }

}
