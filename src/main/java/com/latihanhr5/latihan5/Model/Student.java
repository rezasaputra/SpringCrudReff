package com.latihanhr5.latihan5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String Name;
    @Column(name = "age")
    private String Age;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "student")
    @JsonIgnore
    private Contact contact;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "student")
    @JsonIgnore
    private Set<Assignment> assignmentSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject",joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id",referencedColumnName = "id"))
    @JsonIgnore
    private Set<Subject> subjects;
    public Student(String name, String age, Contact contact) {
        Name = name;
        Age = age;
        this.contact = contact;
    }

}
