package com.example.studentappspring4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "git_hub")
    private String gitHub;
    @Size(min = 3)
    private String start;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            mappedBy = "studentModel"
            //, fetch = FetchType.EAGER//zachłanne pobieranie danych,
            // FetchType.LAZY - odracza inicjalizacje obiektów do momentu aż będą potrzebne
    )
    private Set<TaskModel> tasks = new HashSet<>();

}
