package com.latihanhr5.latihan5.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Subject")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students;
}
