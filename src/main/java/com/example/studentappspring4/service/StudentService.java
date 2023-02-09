package com.example.studentappspring4.service;

import com.example.studentappspring4.model.StudentModel;
import com.example.studentappspring4.repositiry.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repo;

    public List<StudentModel> getAllStudents(){
        return repo.findAll();
    }

    public void addStudent(StudentModel student){
        repo.save(student);
    }

}
