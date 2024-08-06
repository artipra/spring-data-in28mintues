package com.example.jpa.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@NamedQuery(name ="find_all", query="select p from Person p")
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public Course(String name){
        this.name = name;
    }
    public String toString(){
        return String.format("Course [%s]", name);
    }
    public void addReview(Review review){
        reviews.add(review);
    }
    public void removeReview(Review review){
        reviews.remove(review);
    }
}
