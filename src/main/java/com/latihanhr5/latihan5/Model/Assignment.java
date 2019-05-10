package com.latihanhr5.latihan5.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "assignmnet")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Assignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "grade")
    private int grade;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;

    public Assignment(String name, int grade, Student student) {
        this.name = name;
        this.grade = grade;
        this.student = student;
    }
}
