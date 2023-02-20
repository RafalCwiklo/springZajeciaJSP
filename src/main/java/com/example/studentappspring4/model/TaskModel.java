package com.example.studentappspring4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "deadline")
        private Date deadline;
        @Column(name = "description")
        private String description;
        @Column(name = "color")
        private String color;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "creation_date")
        private Date creationDate;


        @ManyToOne
        @JoinColumn(name= "studentModel_id")
        private StudentModel studentModel;
}
