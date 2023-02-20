package com.example.studentappspring4.service;

import com.example.studentappspring4.model.StudentModel;
import com.example.studentappspring4.model.TaskModel;
import com.example.studentappspring4.repositiry.StudentRepository;
import com.example.studentappspring4.repositiry.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class TaskService {
    private final TaskRepository repoTask;

    public List<TaskModel> getAllTasks(){
        return repoTask.findAll();
    }

    public void addTask(TaskModel task){
        repoTask.save(task);
    }

    public TaskModel getTaskById(Long id){
        Optional<TaskModel> task = repoTask.findById(id);
        if(task.isPresent()){
            return repoTask.findById(id).orElse(null);
        }else {
            log.info("nie ma zadania o id: {}", id);
            return null;
        }
    }

    public void deleteTask(Long id) {
        repoTask.deleteById(id);
    }

    public void saveEditTask(TaskModel editTask) {
        repoTask.save(editTask);
    }



}

