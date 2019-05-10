package com.latihanhr5.latihan5.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
    @Column(name = "city")
    public String City;
    @Column(name = "phone")
    public int phone;
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "student_id",nullable = false)
    private  Student student;

    public Contact(String city, int phone, Student student) {
        City = city;
        this.phone = phone;
        this.student = student;
    }
}
