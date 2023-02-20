package com.example.studentappspring4.service;

import com.example.studentappspring4.model.StudentModel;
import com.example.studentappspring4.repositiry.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class StudentService {

    private final StudentRepository repo;

    public List<StudentModel> getAllStudents(){
        return repo.findAll();
    }

    public void addStudent(StudentModel student){
        repo.save(student);
    }

    public StudentModel getStudentById(Long id){
        Optional<StudentModel> student = repo.findById(id);
        if(student.isPresent()){
            return repo.findById(id).orElse(null);
        }else {
            log.info("nie ma studenta o id: {}", id);
            return null;
        }
    }

    public void saveEditStudent(StudentModel editStudent) {
        repo.save(editStudent);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
