package com.example.studentappspring4.controller;

import com.example.studentappspring4.model.StudentModel;
import com.example.studentappspring4.model.TaskModel;
import com.example.studentappspring4.service.StudentService;
import com.example.studentappspring4.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TasksController {

    private final TaskService taskService;

    private final StudentService service;

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        List<TaskModel> taskModelList = taskService.getAllTasks();
        model.addAttribute("taskModel", taskModelList);
        List<StudentModel> studentModelList = service.getAllStudents();
        model.addAttribute("studentModel", studentModelList);
        return "/tasks/tasks";
    }

    @GetMapping("/addTask")
    public String getAddTask() {
        return "/tasks/addTask";
    }

    @PostMapping("/addTask")
    public RedirectView postAddTask(TaskModel task) {
        taskService.addTask(task);
        return new RedirectView("/tasks");
    }
    @GetMapping("/editTask/{id}")
    public String getEditTask(@PathVariable("id") Long id, Model model) {
        TaskModel task = taskService.getTaskById(id);
        model.addAttribute("taskModel", task);
        return "/tasks/tasks";
    }

    @PostMapping("/addTask/{id}")
    public RedirectView postEditTask(TaskModel editTask) {
        taskService.saveEditTask(editTask);
        return new RedirectView("/addTask/{id}");
    }
    @PostMapping("/editTask/{id}")
    public RedirectView deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return new RedirectView("/tasks");
    }
}
