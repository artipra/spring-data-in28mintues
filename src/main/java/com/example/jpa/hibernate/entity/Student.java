package com.example.jpa.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
    @ManyToMany
    @JoinTable(name ="student_course" ,
            joinColumns = @JoinColumn(name ="student_id") ,
            inverseJoinColumns = @JoinColumn(name ="course_id"))
    private List<Course> courses = new ArrayList<>();
    public Student(String name){
        this.name = name;
    }
    public String toString(){
        return String.format("Student [%s]", name);
    }
}
